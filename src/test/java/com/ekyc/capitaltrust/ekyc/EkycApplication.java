package com.ekyc.capitaltrust.ekyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"com.ekyc.capitaltrust.ekyc"}
)
public class EkycApplication {
    public EkycApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(EkycApplication.class, args);
    }
}
