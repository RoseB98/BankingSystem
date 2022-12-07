package com.example.BankingSystem.models;


import com.example.BankingSystem.models.Account.Status;
import com.example.BankingSystem.models.User.AccountHolder;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CheckingDTO {

    private BigDecimal balance;
    private Long primaryOwnerId;
    private Long secondaryOwnerId;
    private String secretKey;

    public CheckingDTO() {
    }

    public CheckingDTO(BigDecimal balance, Long primaryOwnerId, Long secondaryOwnerId, String secretKey) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.secretKey = secretKey;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getPrimaryOwnerId() {
        return primaryOwnerId;
    }

    public void setPrimaryOwnerId(Long primaryOwnerId) {
        this.primaryOwnerId = primaryOwnerId;
    }

    public Long getSecondaryOwnerId() {
        return secondaryOwnerId;
    }

    public void setSecondaryOwnerId(Long secondaryOwnerId) {
        this.secondaryOwnerId = secondaryOwnerId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}