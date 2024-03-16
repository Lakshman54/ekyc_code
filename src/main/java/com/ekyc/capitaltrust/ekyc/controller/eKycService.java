package com.ekyc.capitaltrust.ekyc.controller;

import com.ekyc.capitaltrust.ekyc.utilities.createXMLRequest;
import com.ekyc.capitaltrust.ekyc.utilities.signCertificate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class eKycService {
    private static final Logger log = LoggerFactory.getLogger(eKycService.class);

    @Value("${ekyc.keystorePath}")
    private String keystorePath;

    @Value("${ekyc.alias}")
    private String alias;

    @Value("${ekyc.password}")
    private String password;

    @Autowired
    signCertificate signCertificate;

    @Autowired
    createXMLRequest cXMLRequest;




    public String getXML() {
        try {
            //Step1 Load the keystore with the below properties
       //     log.info("Step 0 load the properties" + keystorePath + alias + password);

            //Step 2 Create the xml String
            String xml = cXMLRequest.createXMLRequest();
            log.info("Step 1st created" );
            log.info(xml);

            //Step 3 Sign the xml
            String signedXML = signCertificate.signXML(xml, alias, password, keystorePath);
            log.info("Step 2nd signed xml created" );
            log.info(signedXML);

            //Step 4 Encode the signed xml using Base64 encoding
            String base64EncodedXML = Base64.getEncoder().encodeToString(signedXML.getBytes());
            log.info("Step 3rd base64 encoded xml created" );
            log.info(base64EncodedXML);





            return base64EncodedXML;



        } catch (Exception e) {
            log.info(e.getMessage());
            return null;
        }
    }
}