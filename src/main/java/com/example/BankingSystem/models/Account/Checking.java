package com.example.BankingSystem.models.Account;

import com.example.BankingSystem.models.User.AccountHolder;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Checking extends Account {

    private BigDecimal minimumBalance = new BigDecimal(250);
    private BigDecimal monthlyMaintenanceFee = new BigDecimal(12);
    private String secretKey;
    private Status status = Status.ACTIVE;

    public Checking() {
    }

    public Checking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
    }

    public void balanceDropsTheMinimum(){
        Checking checkingAccount = null;
        if(checkingAccount.getBalance().compareTo(checkingAccount.getMinimumBalance()) < 0){
             checkingAccount.setBalance(checkingAccount.getBalance().subtract(getPenaltyFee()));
        }
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
