package com.example.BankingSystem.models.Account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sendingAccountId;
    private Long receivingAccountId;
    private BigDecimal transferAmount;
    private String recipientName;

    public Transfer() {
    }

    public Transfer(Long sendingAccountId, Long receivingAccountId, BigDecimal transferAmount, String recipientName) {
        this.sendingAccountId = sendingAccountId;
        this.receivingAccountId = receivingAccountId;
        this.transferAmount = transferAmount;
        this.recipientName = recipientName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
}
