package com.example.BankingSystem.controllers.Account;

import com.example.BankingSystem.models.Account.Account;
import com.example.BankingSystem.models.Account.Checking;
import com.example.BankingSystem.repositories.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checking-account")
public class CheckingController {

    @Autowired
    CheckingRepository checkingRepository;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Checking createCheckingAccount(){

        return null;
    }
}
