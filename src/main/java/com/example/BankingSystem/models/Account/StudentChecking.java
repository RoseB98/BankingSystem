package com.example.BankingSystem.models.Account;

import com.example.BankingSystem.models.User.AccountHolder;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class StudentChecking extends Account {

    private String secretKey;
    private Status status = Status.ACTIVE;

    public StudentChecking() {
    }

    public StudentChecking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
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
