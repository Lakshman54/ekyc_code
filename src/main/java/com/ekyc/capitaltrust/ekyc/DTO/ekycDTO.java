package com.ekyc.capitaltrust.ekyc.DTO;

public class ekycDTO {
    private String transactionId;
    private String responseFormed;
    private String bufferedRequestShared;

    public ekycDTO() {
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getResponseFormed() {
        return this.responseFormed;
    }

    public void setResponseFormed(String responseFormed) {
        this.responseFormed = responseFormed;
    }

    public String getBufferedRequestShared() {
        return this.bufferedRequestShared;
    }

    public void setBufferedRequestShared(String bufferedRequestShared) {
        this.bufferedRequestShared = bufferedRequestShared;
    }
}

