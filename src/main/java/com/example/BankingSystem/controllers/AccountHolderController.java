package com.example.BankingSystem.controllers;

import com.example.BankingSystem.services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class AccountHolderController {

    @Autowired
    AccountHolderService accountHolderService;

    @GetMapping("/get-balance/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public BigDecimal getBalance(@PathVariable Long id){
     return   accountHolderService.showBalance(id);
    }

    @PostMapping("/money-transfer/{id}")
    public void transferMoney(@PathVariable Long id){

    }
}
