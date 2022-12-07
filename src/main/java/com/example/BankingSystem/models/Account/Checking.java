package com.example.BankingSystem.models.Account;

import com.example.BankingSystem.models.User.AccountHolder;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Checking extends Account {

    private BigDecimal minimumBalance = new BigDecimal(250);
    private BigDecimal monthlyMaintenanceFee = new BigDecimal(12);
    private String secretKey;
    private Status status;

    public Checking() {
    }

    public Checking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                    BigDecimal penaltyFee, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee, String secretKey, Status status) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.secretKey = secretKey;
        this.status = status;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
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
