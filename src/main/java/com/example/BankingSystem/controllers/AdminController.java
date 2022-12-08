package com.example.BankingSystem.controllers;

import com.example.BankingSystem.DTOs.CheckingDTO;
import com.example.BankingSystem.DTOs.SavingAndCreditCardDTO;
import com.example.BankingSystem.DTOs.UpdateBalanceDTO;
import com.example.BankingSystem.DTOs.UpdateStatusDTO;
import com.example.BankingSystem.models.Account.*;
import com.example.BankingSystem.models.User.AccountHolder;
import com.example.BankingSystem.models.User.Admin;
import com.example.BankingSystem.repositories.CheckingRepository;
import com.example.BankingSystem.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    AdminService adminService;

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





















    @PostMapping("/create-checking-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addCheckingAccount(@RequestBody CheckingDTO checkingDTO){

        return adminService.createCheckingAccount(checkingDTO);
    }

    @PostMapping("/create-credit-card")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard addCreditCard(@RequestBody SavingAndCreditCardDTO savingAndCreditCardDTO){
        return adminService.createCreditCard(savingAndCreditCardDTO);
    }

    @PostMapping("/create-saving-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings addSavingsAccount(@RequestBody SavingAndCreditCardDTO savingAndCreditCardDTO){
        return adminService.createSavingsAccount(savingAndCreditCardDTO);
    }

    @DeleteMapping("/delete-account/{accountNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccountByAccountNumber(@PathVariable Long accountNumber){

        adminService.deleteAccount(accountNumber);
    }

    @PatchMapping("/update-balance")
    public Account updateBalance(UpdateBalanceDTO updateBalanceDTO){
        return adminService.updateBalance(updateBalanceDTO);
    }

    @PutMapping("/update-account-status")
    public Account updateAccountStatus(@RequestBody UpdateStatusDTO updateStatusDTO){
        return adminService.updateAccountStatus(updateStatusDTO);
    }

    @GetMapping("/get-all-saving-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Savings> findAllSavings(){
        return adminService.findAllSavings();
    }

    @GetMapping("/get-all-credit-cards")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> findAllCreditCards(){
        return adminService.findAllCreditCards();
    }

    @GetMapping("/get-all-checking-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> findAllCheckings(){
        return adminService.findAllCheckings();
    }

    @GetMapping("get-all-student-checking-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentChecking> findAllStudentCheckings(){
        return adminService.findAllStudentCheckings();
    }
}
