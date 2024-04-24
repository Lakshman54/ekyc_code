package com.ekyc.capitaltrust.ekyc.service;


import com.ekyc.capitaltrust.ekyc.DTO.ekycDTO;
import com.ekyc.capitaltrust.ekyc.dao.eKycDao;
import com.ekyc.capitaltrust.ekyc.utilities.createXMLRequest;
import com.ekyc.capitaltrust.ekyc.utilities.signCertificate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.List;

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
    @Autowired
    eKycDao ekycDao;


    public eKycService() {
    }

    public String decrypt(String encryptedxml) throws GeneralSecurityException, IOException {
        log.info("In decrypt method of eKycService");
        String decryptedxml = null;

        try {
            decryptedxml = new String(this.kycResString(encryptedxml));
            return decryptedxml;
        } catch (Exception var4) {
            Exception e = var4;
            throw new RuntimeException(e);
        }
    }

    public byte[] kycResString(String encryptedXml) throws IOException, ParserConfigurationException, SAXException {
        String[] b1 = encryptedXml.split("kycRes");
        String b2 = b1[1].substring(1);
        int endIndex = b2.length() - 3;
        String output = b2.substring(0, endIndex);
        System.out.println("output: " + output);
        return output.getBytes();
    }

    public String getXML() {
        try {
            log.info("Step 0 load the properties" + this.keystorePath + this.alias + this.password);
            String xml = this.cXMLRequest.createXMLRequest();
            log.info("Step 1st created");
            log.info(xml);
            String signedXML = com.ekyc.capitaltrust.ekyc.utilities.signCertificate.signXML(xml, this.alias, this.password, this.keystorePath);
            log.info("Step 2nd signed xml created");
            log.info(signedXML);
            String base64EncodedXML = Base64.getEncoder().encodeToString(signedXML.getBytes());
            log.info("Step 3rd base64 encoded xml created");
            log.info(base64EncodedXML);
            return base64EncodedXML;
        } catch (Exception var4) {
            Exception e = var4;
            log.info(e.getMessage());
            return null;
        }
    }

    public String saveXML(ekycDTO ekycDTO) {
        try {
            this.ekycDao.saveEkyc(ekycDTO);
            return "Success";
        } catch (Exception var3) {
            return "Failed";
        }
    }

    public String updateEkyc(ekycDTO ekycDTO) {
        try {
            this.ekycDao.updateEkyc(ekycDTO);
            return "Success";
        } catch (Exception var3) {
            return "Failed";
        }
    }

    public ekycDTO getEkycbyId(String transactionId) {
        return this.ekycDao.getEkycbyId(transactionId);
    }

    public void deleteEkycbyId(ekycDTO ekycDTO) {
        this.ekycDao.deleteEkyc(ekycDTO);
    }

    public List<ekycDTO> getEkyc() {
        return this.ekycDao.getAlleKyc();
    }
}
