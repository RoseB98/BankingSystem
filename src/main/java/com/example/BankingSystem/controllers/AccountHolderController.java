package com.example.BankingSystem.controllers;

import com.example.BankingSystem.services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
