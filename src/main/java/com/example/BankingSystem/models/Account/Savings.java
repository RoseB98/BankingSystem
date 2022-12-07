package com.example.BankingSystem.models.Account;


import com.example.BankingSystem.models.User.AccountHolder;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

@Entity
public class Savings extends Account {
    @DecimalMax("0.5")
    private BigDecimal interestRate = new BigDecimal(0.0025);
    private String secretKey;
    @Min(value = 100)
    private BigDecimal minimunBalance = new BigDecimal(1000);
    private Status status;

    public Savings() {
    }

    public Savings(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee,
                   BigDecimal interestRate, String secretKey, BigDecimal minimunBalance, Status status) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.interestRate = interestRate;
        this.secretKey = secretKey;
        this.minimunBalance = minimunBalance;
        this.status = status;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getMinimunBalance() {
        return minimunBalance;
    }

    public void setMinimunBalance(BigDecimal minimunBalance) {
        this.minimunBalance = minimunBalance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
