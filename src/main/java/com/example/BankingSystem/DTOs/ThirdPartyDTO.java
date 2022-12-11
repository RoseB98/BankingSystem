package com.example.BankingSystem.DTOs;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class ThirdPartyDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long sendingAccountId;
    private Long receivingAccountId;
    private BigDecimal sendingAmount;

    public ThirdPartyDTO(Long sendingAccountId, Long receivingAccountId, BigDecimal sendingAmount) {
        this.sendingAccountId = sendingAccountId;
        this.receivingAccountId = receivingAccountId;
        this.sendingAmount = sendingAmount;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getSendingAccountId() {
        return sendingAccountId;
    }

    public void setSendingAccountId(Long sendingAccountId) {
        this.sendingAccountId = sendingAccountId;
    }

    public Long getReceivingAccountId() {
        return receivingAccountId;
    }

    public void setReceivingAccountId(Long receivingAccountId) {
        this.receivingAccountId = receivingAccountId;
    }

    public BigDecimal getSendingAmount() {
        return sendingAmount;
    }

    public void setSendingAmount(BigDecimal sendingAmount) {
        this.sendingAmount = sendingAmount;
    }
}
