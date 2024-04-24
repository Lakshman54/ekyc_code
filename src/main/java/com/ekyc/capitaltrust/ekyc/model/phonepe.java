package com.ekyc.capitaltrust.ekyc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "phonepe"
)
public class phonepe {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column(
            name = "RequestGenerated",
            length = 500
    )
    private String requestGenerated;
    @Column(
            name = "ResponseGenerated",
            length = 400
    )
    private String responseGenerated;
    @Column(
            name = "\"Date\"",
            length = 100
    )
    private String date;
    @Column(
            name = "TransactionId",
            length = 200
    )
    private String transactionId;

    @Column(name = "LoanId")
    private Long loanId;

    @Column(name = "CheckstatusResponse", length = 500)
    private String checkstatusResponse;

    public String getCheckstatusResponse() {
        return checkstatusResponse;
    }

    public void setCheckstatusResponse(String checkstatusResponse) {
        this.checkstatusResponse = checkstatusResponse;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public phonepe() {
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResponseGenerated() {
        return this.responseGenerated;
    }

    public void setResponseGenerated(String responseGenerated) {
        this.responseGenerated = responseGenerated;
    }

    public String getRequestGenerated() {
        return this.requestGenerated;
    }

    public void setRequestGenerated(String requestGenerated) {
        this.requestGenerated = requestGenerated;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
