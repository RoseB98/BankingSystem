package com.example.BankingSystem.controllers.Account;

import com.example.BankingSystem.models.Account.Account;
import com.example.BankingSystem.models.Account.Checking;
import com.example.BankingSystem.models.CheckingDTO;
import com.example.BankingSystem.repositories.CheckingRepository;
import com.example.BankingSystem.services.AdminService;
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
    @Autowired
    AdminService adminService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createCheckingAccount(CheckingDTO checkingDTO){

        return adminService.createCheckingAccount(checkingDTO);
    }
}
