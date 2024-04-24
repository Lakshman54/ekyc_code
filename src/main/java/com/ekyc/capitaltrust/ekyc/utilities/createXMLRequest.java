package com.ekyc.capitaltrust.ekyc.utilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
    private String transactionId;

    public createXMLRequest() {
    }

    public String createXMLRequest() throws ParserConfigurationException, TransformerException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element rootElement = doc.createElement("SubAUAReq");
        rootElement.setAttribute("licenseKey", this.licenseKey);
        rootElement.setAttribute("purpose", this.purpose);
        rootElement.setAttribute("reqType", this.reqType);
        rootElement.setAttribute("returnURL", this.returnURL);
        rootElement.setAttribute("subAuaCode", this.subAuaCode);
        String txnId = UUID.randomUUID().toString();
        rootElement.setAttribute("txnId", txnId);
        this.setTransactionId(txnId);
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

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
