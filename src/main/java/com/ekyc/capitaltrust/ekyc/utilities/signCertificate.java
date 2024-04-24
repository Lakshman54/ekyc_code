package com.ekyc.capitaltrust.ekyc.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.KeyException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class signCertificate {
    private static final Logger log = LoggerFactory.getLogger(signCertificate.class);
    public static XMLSignatureFactory fac = null;

    public signCertificate() {
    }

    public static String signXML(String xml, String alias, String password, String keystorePath) throws Exception {
        System.setProperty("com.sun.org.apache.xml.internal.security.ignoreLineBreaks", "true");
        KeyStore keystore = KeyStore.getInstance("JKS");
        FileInputStream fis = new FileInputStream(keystorePath);

        try {
            keystore.load(fis, password.toCharArray());
        } catch (Throwable var17) {
            try {
                fis.close();
            } catch (Throwable var16) {
                var17.addSuppressed(var16);
            }

            throw var17;
        }

        fis.close();
        fis = null;
        PrivateKey privateKey = (PrivateKey)keystore.getKey(alias, password.toCharArray());
        X509Certificate certificate = (X509Certificate)keystore.getCertificate(alias);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder var8 = dbf.newDocumentBuilder();
        Document document = var8.parse(new InputSource(new StringReader(xml)));
        fac = XMLSignatureFactory.getInstance("DOM");
        Reference ref = fac.newReference("", fac.newDigestMethod("http://www.w3.org/2000/09/xmldsig#sha1", (DigestMethodParameterSpec)null), Collections.singletonList(fac.newTransform("http://www.w3.org/2000/09/xmldsig#enveloped-signature", (TransformParameterSpec)null)), (String)null, (String)null);
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (C14NMethodParameterSpec)null), fac.newSignatureMethod("http://www.w3.org/2000/09/xmldsig#rsa-sha1", (SignatureMethodParameterSpec)null), Collections.singletonList(ref));
        if (privateKey != null && certificate != null) {
            DOMSignContext dsc = new DOMSignContext(privateKey, document.getDocumentElement());
            KeyInfo ki = createKeyInfo(certificate.getPublicKey(), certificate);
            XMLSignature signature = fac.newXMLSignature(si, ki);
            signature.sign(dsc);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            StringWriter sw = new StringWriter();
            trans.transform(new DOMSource(document), new StreamResult(sw));
            String output = sw.toString();
            return output;
        } else {
            throw new Exception("Private key or certificate not found in keystore");
        }
    }

    private static KeyInfo createKeyInfo(PublicKey publicKey, X509Certificate x509Certificate) throws KeyException {
        KeyInfoFactory keyInfoFactory = fac.getKeyInfoFactory();
        KeyInfo keyInfo = null;
        List items = null;
        if (x509Certificate != null) {
            List x509list = new ArrayList();
            x509list.add(x509Certificate.getSubjectX500Principal().getName());
            x509list.add(x509Certificate);
            X509Data x509Data = keyInfoFactory.newX509Data(x509list);
            items = new ArrayList();
            items.add(x509Data);
            keyInfo = keyInfoFactory.newKeyInfo(items);
        }

        return keyInfo;
    }
}
