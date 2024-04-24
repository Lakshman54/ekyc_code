package com.ekyc.capitaltrust.ekyc.model;

public class ChecksumInputParam {
    int loanid;
    int paymenttype;
    String targettype;
    int amount;

    public ChecksumInputParam() {
    }

    public int getLoanid() {
        return this.loanid;
    }

    public void setLoanid(int loanid) {
        this.loanid = loanid;
    }

    public int getPaymenttype() {
        return this.paymenttype;
    }

    public void setPaymenttype(int paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getTargettype() {
        return this.targettype;
    }

    public void setTargettype(String targettype) {
        this.targettype = targettype;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
