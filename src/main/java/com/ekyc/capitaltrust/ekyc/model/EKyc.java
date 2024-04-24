package com.ekyc.capitaltrust.ekyc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "eKyc"
)
public class EKyc {
    @Id
    @Column(
            name = "TransactionId",
            nullable = false,
            length = 400
    )
    private String transactionId;
    @Column(
            name = "BufferedRequestShared",
            length = 900
    )
    private String bufferedRequestShared;
    @Column(
            name = "response_formed",
            length = 400
    )
    private String responseFormed;

    public EKyc() {
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getBufferedRequestShared() {
        return this.bufferedRequestShared;
    }

    public void setBufferedRequestShared(String bufferedRequestShared) {
        this.bufferedRequestShared = bufferedRequestShared;
    }

    public String getResponseFormed() {
        return this.responseFormed;
    }

    public void setResponseFormed(String responseFormed) {
        this.responseFormed = responseFormed;
    }
}
