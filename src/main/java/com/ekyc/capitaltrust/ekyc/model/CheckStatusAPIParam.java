package com.ekyc.capitaltrust.ekyc.model;

public class CheckStatusAPIParam {
    String merchantTransactionId;

    public CheckStatusAPIParam() {
    }

    public String getMerchantTransactionId() {
        return this.merchantTransactionId;
    }

    public void setMerchantTransactionId(String merchantTransactionId) {
        this.merchantTransactionId = merchantTransactionId;
    }
}
