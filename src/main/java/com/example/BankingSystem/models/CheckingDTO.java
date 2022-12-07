package com.example.BankingSystem.models;


import java.math.BigDecimal;
import java.time.LocalDate;

public class CheckingDTO {

    private BigDecimal balance;
    private Long primaryOwnerId;
    private String secretKey;
    private LocalDate creationDate;

    public CheckingDTO() {
    }

    public CheckingDTO(BigDecimal balance, Long primaryOwnerId, String secretKey, LocalDate creationDate) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secretKey = secretKey;
        this.creationDate = creationDate;
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

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}