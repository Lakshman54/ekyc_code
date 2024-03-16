package com.ekyc.capitaltrust.ekyc.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.security.KeyException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;


@Component
public class signCertificate {

    private static final Logger log = LoggerFactory.getLogger(signCertificate.class);
    public static XMLSignatureFactory fac=null;
    public static String signXML(String xml, String alias, String password, String keystorePath) throws Exception {

        // Set the ignoreLineBreaks property to true
        System.setProperty("com.sun.org.apache.xml.internal.security.ignoreLineBreaks", "true");
        // Load the keystore
        KeyStore keystore = KeyStore.getInstance("JKS");

        try (FileInputStream fis = new FileInputStream(keystorePath)) {
            keystore.load(fis, password.toCharArray());
        }

        // Get the private key and certificate
        PrivateKey privateKey = null;
        privateKey = (PrivateKey) keystore.getKey(alias, password.toCharArray());


        X509Certificate certificate = (X509Certificate) keystore.getCertificate(alias);

        // Create a DOM document
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new InputSource(new StringReader(xml)));

        // Create a signature factory
        fac = XMLSignatureFactory.getInstance("DOM");

        // Create a reference to the enveloped document
        Reference ref = fac.newReference("", fac.newDigestMethod(DigestMethod.SHA1, null),
                singletonList(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)),
                null, null);

        // Create the SignedInfo
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
                        (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                singletonList(ref));

        if (privateKey == null || certificate == null) {
            throw new Exception("Private key or certificate not found in keystore");
        } else {
            // Create a signature context and set the key and the signature factory
            DOMSignContext dsc = new DOMSignContext(privateKey, document.getDocumentElement());

            // Add X509Data to KeyInfo
            KeyInfo ki = createKeyInfo(certificate.getPublicKey(), certificate);

            // Create the XML signature and sign it
            XMLSignature signature = fac.newXMLSignature(si, ki);

            // Signing the document
            signature.sign(dsc);
        }

        // Output the signed XML
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        StringWriter sw = new StringWriter();
        trans.transform(new DOMSource(document), new StreamResult(sw));

        String output = sw.toString();

      //  log.info("Signed XML: " + output);
        return output;
    }

    private static KeyInfo createKeyInfo(PublicKey publicKey, X509Certificate x509Certificate) throws KeyException {
        KeyInfoFactory keyInfoFactory = fac.getKeyInfoFactory();
        KeyInfo keyInfo = null;

        List items = null;


        if(x509Certificate != null){
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
