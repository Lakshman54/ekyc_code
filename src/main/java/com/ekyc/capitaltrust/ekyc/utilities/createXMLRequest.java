package com.ekyc.capitaltrust.ekyc.utilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.time.Instant;
import java.util.UUID;

@Component
public class createXMLRequest {
     @Value("${ekyc.licenseKey}")
     private String licenseKey;

     @Value("${ekyc.purpose}")
     private String purpose;

     @Value("${ekyc.reqType}")
     private String reqType;

     @Value("${ekyc.returnURL}")
     private String returnURL;

     @Value("${ekyc.subAuaCode}")
     private String subAuaCode;

   public String createXMLRequest() throws ParserConfigurationException, TransformerException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element rootElement = doc.createElement("SubAUAReq");
        rootElement.setAttribute("licenseKey", licenseKey);
        rootElement.setAttribute("purpose", purpose);
        rootElement.setAttribute("reqType", reqType);
        rootElement.setAttribute("returnURL", returnURL);
        rootElement.setAttribute("subAuaCode", subAuaCode);

        // Generate a unique txnId
        String txnId = UUID.randomUUID().toString();
        rootElement.setAttribute("txnId", txnId);

        // Generate a unique timestamp
        Instant now = Instant.now();
        String ts = now.toString();
        rootElement.setAttribute("ts", ts);

        doc.appendChild(rootElement);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));

        return writer.getBuffer().toString();
    }

    public String CreateXML2()
    {
         try {
              DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
              DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
              Document document = documentBuilder.newDocument();

              // Create root element
              org.w3c.dom.Element root = document.createElement("SubAUAReq");
              root.setAttribute("licenseKey", licenseKey);
              root.setAttribute("purpose", purpose);
              root.setAttribute("reqType", reqType);
              root.setAttribute("returnURL", "https://sample.com/B2BResponseServlet");
              root.setAttribute("subAuaCode", subAuaCode);
              root.setAttribute("ts", "2023-05-11T14:09:03.341+05:30");
              root.setAttribute("txnId", "SAMPLE0001:20230511020903340");

              // Create Signature element
              org.w3c.dom.Element signature = document.createElement("Signature");
              signature.setAttribute("xmlns", "http://www.w3.org/2000/09/xmldsig#");
              // Add Signature content here

              // Append Signature to root
              root.appendChild(signature);

              // Append root to document
              document.appendChild(root);

              // Transform document to XML string
              TransformerFactory transformerFactory = TransformerFactory.newInstance();
              Transformer transformer = transformerFactory.newTransformer();
              StringWriter writer = new StringWriter();
              transformer.transform(new DOMSource(document), new StreamResult(writer));

              return writer.getBuffer().toString();
         } catch (Exception e) {
              e.printStackTrace();
         }

         return null;
    }

}