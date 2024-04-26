package com.ekyc.capitaltrust.ekyc.controller;


import com.ekyc.capitaltrust.ekyc.DTO.ekycDTO;
import com.ekyc.capitaltrust.ekyc.service.eKycService;
import com.ekyc.capitaltrust.ekyc.utilities.DataDecryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping({"/eKyc"})
@RestController
public class eKycController {
    public final double EARTH_RADIUS = 6371.0;
    private static final Logger log = LoggerFactory.getLogger(eKycController.class);
    @Autowired
    eKycService kycService;

    public eKycController() {
    }

    @PostMapping({"/decrypt"})
    public String decrypt(@RequestBody String decryptedxml) {
        try {


            String responseXML = decryptedxml;
            DataDecryptor dataDecryptor=new DataDecryptor("SignerPublickey.jks", "Capitaltrust@123".toCharArray(),"te-a8dcf4d6-ff68-47df-bc11-c1ccbf2411ba");



      String xml= dataDecryptor.decrypt(decryptedxml);

            return xml;
        } catch (Exception var3) {
            Exception e = var3;
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping({"/getXML"})
    public String getXML() {
        log.info("In getXML method of eKycController");
        return this.kycService.getXML();
    }

    @GetMapping({"/getEkyc"})
    public List<ekycDTO> getEkyc() {
        log.info("In getEkyc method of eKycController");
        return this.kycService.getEkyc();
    }

    @PostMapping({"/decryptxml"})
    public String decyptxml(@RequestParam("encryptedxml") String encryptedxml) {
        log.info("Decryptxml data:");
        return "Success";
    }

    @PostMapping({"/saveXML"})
    public String saveXML(@RequestBody ekycDTO ekycDTO) {
        log.info("In saveXML method of eKycController");
        return this.kycService.saveXML(ekycDTO);
    }

    @PutMapping({"/updateEkyc"})
    public String updateEkyc(@RequestBody ekycDTO ekycDTO) {
        log.info("In updateEkyc method of eKycController");
        return this.kycService.updateEkyc(ekycDTO);
    }

    @GetMapping({"/getEkycbyId/{transactionId}"})
    public ekycDTO getEkycbyId(@PathVariable("transactionId") String transactionId) {
        log.info("In getEkycbyId method of eKycController");
        return this.kycService.getEkycbyId(transactionId);
    }

    @DeleteMapping({"/deleteEkycbyId"})
    public void deleteEkycbyId(@RequestBody ekycDTO ekycDTO) {
        log.info("In deleteEkycbyId method of eKycController");
        this.kycService.deleteEkycbyId(ekycDTO);
    }
}
