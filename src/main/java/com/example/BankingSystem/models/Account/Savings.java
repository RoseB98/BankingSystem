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
    private Status status = Status.ACTIVE;

    public Savings() {
    }

    public Savings(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
    }

    public void balanceDropsTheMinimum(){
        Savings savingsAccount = null;
        if(savingsAccount.getBalance().compareTo(savingsAccount.getMinimunBalance()) < 0){
            savingsAccount.setBalance(savingsAccount.getBalance().subtract(getPenaltyFee()));
        }
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
