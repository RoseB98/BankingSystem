package com.example.BankingSystem.controllers;

import com.example.BankingSystem.DTOs.CheckingDTO;
import com.example.BankingSystem.DTOs.UpdateBalanceDTO;
import com.example.BankingSystem.models.Account.Account;
import com.example.BankingSystem.models.User.AccountHolder;
import com.example.BankingSystem.models.User.Admin;
import com.example.BankingSystem.repositories.CheckingRepository;
import com.example.BankingSystem.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    AdminService adminService;

    @PostMapping("/create-checking-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addCheckingAccount(@RequestBody CheckingDTO checkingDTO){

        return adminService.createCheckingAccount(checkingDTO);
    }

    @PostMapping("/create-account-holder")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder){

        return adminService.createAccountHolder(accountHolder);
    }

    @PostMapping("/create-admin")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin addAdmin(@RequestBody Admin admin){

        return adminService.createAdmin(admin);
    }

    @PatchMapping("/update-balance")
    public Account updateBalance(UpdateBalanceDTO updateBalanceDTO){
       return adminService.updateBalance(updateBalanceDTO);
    }
}
