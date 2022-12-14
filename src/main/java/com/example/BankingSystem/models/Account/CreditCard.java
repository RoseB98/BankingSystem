package com.example.BankingSystem.models.Account;

import com.example.BankingSystem.models.Account.Account;
import com.example.BankingSystem.models.User.AccountHolder;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class CreditCard extends Account {

    @Min(value = 100)
    @Max(value = 100000)
    private BigDecimal creditLimit = new BigDecimal(100);
    @DecimalMax("0.21")
    @DecimalMin("0.1")
    private BigDecimal interestRate = new BigDecimal(0.2);

    private LocalDate lastInterestAdded = LocalDate.now();

    public CreditCard() {
    }

    public CreditCard(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, primaryOwner, secondaryOwner);
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getLastInterestAdded() {
        return lastInterestAdded;
    }

    public void setLastInterestAdded(LocalDate lastInterestAdded) {
        this.lastInterestAdded = lastInterestAdded;
    }
}
