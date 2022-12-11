package com.example.BankingSystem.controllers;

import com.example.BankingSystem.DTOs.CheckingDTO;
import com.example.BankingSystem.DTOs.SavingAndCreditCardDTO;
import com.example.BankingSystem.DTOs.UpdateBalanceDTO;
import com.example.BankingSystem.DTOs.UpdateStatusDTO;
import com.example.BankingSystem.models.Account.*;
import com.example.BankingSystem.models.User.AccountHolder;
import com.example.BankingSystem.models.User.Admin;
import com.example.BankingSystem.models.User.Role;
import com.example.BankingSystem.models.User.ThirdParty;
import com.example.BankingSystem.repositories.AccountRepository;
import com.example.BankingSystem.repositories.CheckingRepository;
import com.example.BankingSystem.repositories.RoleRepository;
import com.example.BankingSystem.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin-area")
public class AdminController {

    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    AdminService adminService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/create-account-holder")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder addAccountHolder(@RequestBody AccountHolder accountHolder){

        String encodedPassword = passwordEncoder.encode(accountHolder.getPassword());
        accountHolder.setPassword(encodedPassword);
        AccountHolder accountHolder1 = adminService.createAccountHolder(accountHolder);
        Role role = roleRepository.save(new Role("ACCOUNT-HOLDER", accountHolder));
        return accountHolder1;
    }

    @PostMapping("/create-admin")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin addAdmin(@RequestBody Admin admin){

        String encodedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);
        Admin admin1 = adminService.createAdmin(admin);
        Role role = roleRepository.save(new Role("ADMIN", admin));
        return admin1;
    }

    @PostMapping("/create-third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty addThirdParty (@RequestBody ThirdParty thirdParty){

        String hashedKey = passwordEncoder.encode(thirdParty.getHashedKey());
        thirdParty.setHashedKey(hashedKey);
        ThirdParty thirdParty1 = adminService.createThirdParty(thirdParty);
        Role role = roleRepository.save(new Role("THIRD-PARTY", thirdParty));
        return  thirdParty1;
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
