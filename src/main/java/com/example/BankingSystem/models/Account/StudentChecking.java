package com.example.BankingSystem.models.Account;

import com.example.BankingSystem.models.User.AccountHolder;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class StudentChecking extends Account {

    private String secretKey;
    private Status status;

    public StudentChecking() {

    }

    public StudentChecking(BigDecimal balance, AccountHolder primaryOwner,
                           AccountHolder secondaryOwner, BigDecimal penaltyFee, String secretKey, Status status) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.status = status;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
