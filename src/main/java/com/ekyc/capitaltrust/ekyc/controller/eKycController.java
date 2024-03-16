package com.ekyc.capitaltrust.ekyc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/eKyc")
@RestController
public class eKycController  {
    private static final Logger log = LoggerFactory.getLogger(eKycController.class);

    @Autowired
    eKycService kycService;

    @GetMapping(value = "/getXML")
    public String getXML() {
        log.info("In getXML method of eKycController");
        return kycService.getXML();
    }
}
