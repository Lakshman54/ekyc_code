/**
 * DISCLAIMER: The sample code or utility or tool described herein
 * is provided on an "as is" basis, without warranty of any kind.
 * UIDAI does not warrant or guarantee the individual success
 * developers may have in implementing the sample code on their
 * environment. 
 * 
 * UIDAI does not warrant, guarantee or make any representations
 * of any kind with respect to the sample code and does not make
 * any representations or warranties regarding the use, results
 * of use, accuracy, timeliness or completeness of any data or
 * information relating to the sample code. UIDAI disclaims all
 * warranties, express or implied, and in particular, disclaims
 * all warranties of merchantability, fitness for a particular
 * purpose, and warranties related to the code, or any service
 * or software related thereto. 
 * 
 * UIDAI is not responsible for and shall not be liable directly
 * or indirectly for any direct, indirect damages or costs of any
 * type arising out of use or any action taken by you or others
 * related to the sample code.
 * 
 * THIS IS NOT A SUPPORTED SOFTWARE.
 * 
 */

package com.ekyc.capitaltrust.ekyc.utilities;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.encodings.OAEPEncoding;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;


public class DataDecryptor {

	private static final int PUBLIC_KEY_SIZE = 294;
	private static final int EID_SIZE = 32;
	private static final int SECRET_KEY_SIZE = 256;
	private static final String TRANSFORMATION = "RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING";
	private static final String SECURITY_PROVIDER = "BC";
	private static final String DIGEST_ALGORITHM = "SHA-256";
	private static final String MASKING_FUNCTION = "MGF1";
	private static final int VECTOR_SIZE = 16;
	private static final int HMAC_SIZE = 32;
	private static final int BLOCK_SIZE = 128;
	private static final byte[] HEADER_DATA = "VERSION_1.0".getBytes();
	private static final String SIGNATURE_TAG = "Signature";
	private static final String MEC_TYPE = "DOM";
	
	private KeyStore.PrivateKeyEntry privateKey;
	private String publicKeyFile;
	static{
	Security.addProvider(new BouncyCastleProvider());
	}

	public String kycResString(String encryptedXml) throws IOException, ParserConfigurationException, SAXException {
		String[] b1=  encryptedXml.split("kycRes");
		String b2=b1[1].substring(1);
		int endIndex = b2.length() - 2;
		String output = b2.substring(0, endIndex);

		System.out.println("output: " + output);

		return output;
	}

	public String DecKeyString(String encryptedXml) throws IOException, ParserConfigurationException, SAXException {
		String[] b1=  encryptedXml.split("DecKey");
		String b2=b1[1].substring(1);
		int endIndex = b2.length() - 2;
		String output = b2.substring(0, endIndex);

		return output;
	}

	public String KycString(String encryptedXml) throws IOException, ParserConfigurationException, SAXException {
		String[] b1=  encryptedXml.split("kycRes");
		String b2=b1[1].substring(1);
		int endIndex = b2.length() - 2;
		String output = b2.substring(0, endIndex);

		System.out.println("output: " + output);

		return output;
	}


	/**
	 * Constructor
	 * @param keyStoreFile - Location of .p12 file
	 * @param keyStorePassword - Password of .p12 file
	 * @param publicKeyFile - Alias of the certificate in .p12 file
	 */
	public DataDecryptor(String keyStoreFile, char[] keyStorePassword, String publicKeyFile) {
		this.privateKey = getKeyFromFile(keyStoreFile, keyStorePassword);
		this.publicKeyFile = publicKeyFile;
		
		if (privateKey == null) {
			throw new RuntimeException("Key could not be read for digital signature. Please check value of signature "
					+ "alias and signature password, and restart the Auth Client");
		}
	}

	public KeyPair loadPrivateKeyFromPemFile(String pemFilePath) throws IOException {
		JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
		PEMParser pemParser = new PEMParser(new FileReader(pemFilePath));
		Object object = pemParser.readObject();
		PEMKeyPair pemKeyPair = (PEMKeyPair) object;
		KeyPair keyPair = converter.getKeyPair(pemKeyPair);
		pemParser.close();
		return keyPair;
	}

	public String DecKeyValue(String xmlString) {
		String decKeyValue=null;
		String[] xmlParts = xmlString.split("<DecKey>");
		if (xmlParts.length > 1) {
			String[] decKeyParts = xmlParts[1].split("</DecKey>");
			if (decKeyParts.length > 0) {
				decKeyValue= decKeyParts[0].trim();
				System.out.println("DecKey value: " + decKeyValue);
			} else {
				System.out.println("DecKey node not found.");
			}
		} else {
			System.out.println("DecKey node not found.");
		}

		return decKeyValue;
	}
	
	public String decrypt(String data) throws Exception {
		//kycRes
		byte[] encKycStr=	CustomBase64.decodeBase64(KycString(data));
		byte[] deckey= CustomBase64.decodeBase64(DecKeyString(data));
		System.out.println("decrypt key data: " + DecKeyString(data)+" length: " + deckey.length);
		String decryptedstring=decryptUsingSymmetricKey(encKycStr,decryptSessionKey(deckey));
		return decryptedstring;
	}
	public String decryptUsingSymmetricKey(byte[] EncryptedKycRes, byte[] sessionKey) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException
	{
		Cipher cipher = Cipher.getInstance("AES");
		SecretKeySpec secretKey = new SecretKeySpec(sessionKey, "AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		String decryptedString = new String(cipher.doFinal(EncryptedKycRes));
		return decryptedString;
	}

	private byte[] decryptSessionKey(byte[] decodedSessionKey) {

		String privateDecKeypath="eMudhraCertificate.pfx";

		String password="Capitaltrust@123";
		String alias="te-a8dcf4d6-ff68-47df-bc11-c1ccbf2411ba";

		KeyStore.PrivateKeyEntry privateKey = getKeyFromFile(privateDecKeypath, password.toCharArray());
		//KeyStore.PrivateKeyEntry privateKey = getKeyFromFile(privateDecKeypath, password.toCharArray(),alias);

		byte[] decryptedSessionKey = null;
		try {
			// get an RSA cipher object and print the provider
			final Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","BC");

			// decrypt the text using the private key
			cipher.init(Cipher.DECRYPT_MODE, privateKey.getPrivateKey());
			decryptedSessionKey = cipher.doFinal(decodedSessionKey);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return decryptedSessionKey;
	}




	private static KeyStore.PrivateKeyEntry getKeyFromFile(String keyStoreFile, char[] keyStorePassword,String alias) {
		FileInputStream keyFileStream = null;
		try {
			// Load the KeyStore and get the signing key and certificate.
			KeyStore ks = KeyStore.getInstance("PKCS12");
			keyFileStream = new FileInputStream(keyStoreFile);
			ks.load(keyFileStream, keyStorePassword);
			String alias1 = ks.aliases().nextElement();
			System.out.println("in getKeyFromFile in decryptor "+keyStoreFile+":"+keyStorePassword+":"+alias1+":");
			KeyStore.PrivateKeyEntry  entry = (KeyStore.PrivateKeyEntry) ks.getEntry
					(alias, new KeyStore.PasswordProtection(keyStorePassword));

			if(entry == null)
				throw new Exception("Key not found for the given alias.");
			return entry;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (keyFileStream != null) {
				try {
					keyFileStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	
	/**
	 * To convert xml string with digital signature
	 * @param document: Document
	 * @return xmlString: String
	 * @throws Exception
	 */
	private static String covertDocumentToString(Document document) throws Exception{
		java.io.StringWriter sw = new java.io.StringWriter();
		try {
		DOMSource domSource = new DOMSource(document);
	    TransformerFactory tf = TransformerFactory.newInstance();
	    Transformer transformer = tf.newTransformer();

	    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	    //transformer.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");
	    //transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
	    //transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	    StreamResult sr = new StreamResult(sw);
	    transformer.transform(domSource, sr);
		}catch (TransformerException e) {
			e.printStackTrace();
		}

	  return  sw.toString();
	 }

	private static void printUsage() {
		System.out.println("Please provide command-line arguments.");
		System.out.println("Syntax: java DecryptDataAndVerifySignature <ENC_FILE_PATH> <KEY_STORE_FILE_PATH> <KEY_STORE_PWD> <CERTIFICATE_FILE>");
		System.out.println("For Eg: java DecryptDataAndVerifySignature enc.xml keyStore.p12 test@123 certificate.cer");
	}
	
	public static byte[] getDataFromFile(String fileName) throws Exception {
		
		FileInputStream inputStream = new FileInputStream(fileName);
		byte[] encBytes = new byte[inputStream.available()];
		inputStream.read(encBytes, 0, encBytes.length);
		inputStream.close();
		return encBytes;
	}
	
	public static void writeToFile(byte[] plainData, String fileName) throws Exception {

		FileOutputStream os = new FileOutputStream(fileName);
		os.write(plainData, 0, plainData.length);
		os.flush();
		os.close();
	}
	
	private Document getDomObject(String string) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
		dbf.setNamespaceAware(true);
		DocumentBuilder builder = dbf.newDocumentBuilder();
		return builder.parse(new InputSource(new StringReader(string)));
	}
	
	private String getOutputFilename(String encryptedFile) {
		
		return encryptedFile + ".xml";
	}
	
	private PublicKey getPublicKey(String certFile) throws Exception {
		CertificateFactory factory = CertificateFactory.getInstance("X.509");
		FileInputStream fis = new FileInputStream(certFile);
		Certificate cert = factory.generateCertificate(fis);
		//fis.close();
		return cert.getPublicKey();
	}
	
	private KeyStore.PrivateKeyEntry getKeyFromFile(String keyStoreFile, char[] keyStorePassword) {
		
		try {
			// Load the KeyStore and get the signing key and certificate.
			KeyStore ks = KeyStore.getInstance("PKCS12");
			FileInputStream keyFileStream = new FileInputStream(keyStoreFile);
			ks.load(keyFileStream, keyStorePassword);
			String alias = ks.aliases().nextElement();
			
			KeyStore.PrivateKeyEntry  entry = (KeyStore.PrivateKeyEntry) ks.getEntry
			        (alias, new KeyStore.PasswordProtection(keyStorePassword));
			
			if(entry == null)
				throw new Exception("Key not found for the given alias.");
			
			keyFileStream.close();
			
			return entry;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private byte[] decryptSecretKeyData(byte[] encryptedSecretKey, byte[] iv, PrivateKey privateKey, RSAKeyParameters rsaKeyParam ) throws Exception {

		try {

			Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			rsaCipher.init(Cipher.DECRYPT_MODE, privateKey);

			byte[] paddedPlainText  = rsaCipher.doFinal(encryptedSecretKey);

			BigInteger exp = new BigInteger("1", 16);
			RSAKeyParameters p_Temp = new RSAKeyParameters(false,rsaKeyParam.getModulus(),exp);
			AsymmetricBlockCipher cipher = new OAEPEncoding(new RSAEngine(),  new SHA256Digest(),iv);
			cipher.init(false,p_Temp);
			return cipher.processBlock(paddedPlainText, 0, paddedPlainText.length);

		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			throw new Exception("Failed to decrypt AES secret key using RSA.", e);
		}
	}
	
	private byte[] decryptData(byte[] encryptedData, byte[] eid, byte[] secretKey) throws Exception {
		try {
			byte[][] iv = split(eid, VECTOR_SIZE);
			
			BufferedBlockCipher cipher = new BufferedBlockCipher(new CFBBlockCipher(new AESEngine(), BLOCK_SIZE));
			KeyParameter key = new KeyParameter(secretKey);
			
			cipher.init(false, new ParametersWithIV(key, iv[0]));
			
			int outputSize = cipher.getOutputSize(encryptedData.length);
			
			byte[] result = new byte[outputSize];
			int processLen = cipher.processBytes( encryptedData, 0, encryptedData.length, result, 0);
			cipher.doFinal(result, processLen);
			return result;
		}
		catch(InvalidCipherTextException txtExp) {
			throw new Exception("Decrypting data using AES failed", txtExp);
		}
	}
	
	private boolean validateHash(byte[] decryptedText) throws Exception {
		byte[][] hs = split(decryptedText, HMAC_SIZE);
		try {
			byte[] actualHash = generateHash(hs[1]);
			if (new String(hs[0], "UTF-8").equals(new String(actualHash, "UTF-8"))) {
				return true;
			} else {
				return false;
			}
		} 
		catch(Exception he) {
			throw new Exception("Not able to compute hash.", he);
		}
	}
	
	private byte[] trimHMAC(byte[] decryptedText) {
		byte[] actualText;
		if (decryptedText == null || decryptedText.length <= HMAC_SIZE) {
			actualText = new byte[0];
		} else {
			actualText = new byte[decryptedText.length - HMAC_SIZE];
			System.arraycopy(decryptedText, HMAC_SIZE, actualText, 0,
					actualText.length);
		}
		return actualText;
	}
	
	private static class ByteArraySpliter {
		
		private final byte[] headerVersion;
		private final byte[] iv; 
		private final byte[] encryptedSecretKey;
		private final byte[] encryptedData;
		private final byte[] publicKeyData;

		public ByteArraySpliter(byte[] data) throws Exception {
			int offset = 0;
			headerVersion = new byte[HEADER_DATA.length];
			copyByteArray(data, 0, headerVersion.length, headerVersion);
			offset = offset + HEADER_DATA.length;
			publicKeyData = new byte[PUBLIC_KEY_SIZE];
			copyByteArray(data, offset, publicKeyData.length, publicKeyData);
			offset = offset + PUBLIC_KEY_SIZE;
			iv = new byte[EID_SIZE];
			copyByteArray(data, offset, iv.length, iv);
			offset = offset + EID_SIZE;
			encryptedSecretKey = new byte[SECRET_KEY_SIZE];
			copyByteArray(data, offset, encryptedSecretKey.length, encryptedSecretKey);
			offset = offset + SECRET_KEY_SIZE;
			encryptedData = new byte[data.length - offset];
			copyByteArray(data, offset, encryptedData.length, encryptedData);
		}

		public byte[] getIv() {
			return iv;
		}

		public byte[] getEncryptedSecretKey() {
			return encryptedSecretKey;
		}

		public byte[] getEncryptedData() {
			return encryptedData;
		}

		public byte[] getPublicKeyData() {
			return publicKeyData;
		}

		private void copyByteArray(byte[] src, int offset, int length, byte[] dest) throws Exception {
			try {
				System.arraycopy(src, offset, dest, 0,length);
			}
			catch(Exception e) {

				throw new Exception("Decryption failed, Corrupted packet ", e);
			}
		}

	}
	
	private byte[][] split(byte[] src, int n) {
		byte[] l, r;
		if (src == null || src.length <= n) {
			l = src;
			r = new byte[0];
		} else {
			l = new byte[n];
			r = new byte[src.length - n];
			System.arraycopy(src, 0, l, 0, n);
			System.arraycopy(src, n, r, 0, r.length);
		}
		return new byte[][] { l, r };
	}
	
	public byte[] generateHash(byte[] message) throws Exception {
		byte[] hash = null;
		try {
			// Registering the Bouncy Castle as the RSA provider.
			MessageDigest digest = MessageDigest.getInstance(DIGEST_ALGORITHM, SECURITY_PROVIDER);
			digest.reset();
			hash = digest.digest(message);
		} catch (GeneralSecurityException e) {
			throw new Exception("SHA-256 Hashing algorithm not available");
		}
		return hash;
	}
	
	public boolean verify(String xml) throws Exception {
		try {
			Document xmlDoc = getDomObject(xml);
			PublicKey publicKey = getPublicKey(publicKeyFile);
			NodeList nl = xmlDoc.getElementsByTagNameNS(XMLSignature.XMLNS, SIGNATURE_TAG);
			if (nl.getLength() == 0) 
			    throw new IllegalArgumentException("Cannot find Signature element");
			
			XMLSignatureFactory fac = XMLSignatureFactory.getInstance(MEC_TYPE);
			
			DOMValidateContext valContext = new DOMValidateContext(publicKey, nl.item(0));
			XMLSignature signature = fac.unmarshalXMLSignature(valContext);
			
			return signature.validate(valContext);
		}
		catch(MarshalException mExp) {
			throw new Exception(mExp);
		} catch (XMLSignatureException xmlExp) {
			throw new Exception(xmlExp);
		}
	}
	
	private static Node getSignatureNode(Document inputDocument) {
		if (inputDocument != null) {
			Element rootElement = inputDocument.getDocumentElement();
			if (rootElement != null) {
				NodeList nl = rootElement.getChildNodes();
				if (nl != null) {
					for (int i = 0; i < nl.getLength(); i++) {
						Node n = nl.item(i);
						if (n != null) {
							if (n.getNodeName() != null && "signature".equalsIgnoreCase(n.getLocalName())) {
								return n;
							}
						}
					}
				}
			}
		}
		
		return null;
	}

	public static Document removeSignature(Document inputDocument) {
		
		if (inputDocument != null) {
			Element rootElement = inputDocument.getDocumentElement();
			Node n = getSignatureNode(inputDocument);
			if (n != null) {
				rootElement.removeChild(n);
			}
		}
		
		return inputDocument;
	}
}
