package com.example.BankingSystem.DTOs;

import java.math.BigDecimal;

public class UpdateBalanceDTO {
    private BigDecimal newBalance;
    private Long accountId;

    public UpdateBalanceDTO() {
    }

    public UpdateBalanceDTO(BigDecimal newBalance, Long accountId) {
        this.newBalance = newBalance;
        this.accountId = accountId;
    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
