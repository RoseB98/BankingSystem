package com.example.BankingSystem.DTOs;

import com.example.BankingSystem.models.Account.Status;

public class UpdateStatusDTO {

    private Long accountId;
    private Status status;

    public UpdateStatusDTO(Long accountId, Status status) {
        this.accountId = accountId;
        this.status = status;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
