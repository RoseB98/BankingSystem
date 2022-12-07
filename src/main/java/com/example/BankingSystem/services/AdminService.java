package com.example.BankingSystem.services;

import com.example.BankingSystem.DTOs.CheckingDTO;
import com.example.BankingSystem.DTOs.UpdateBalanceDTO;
import com.example.BankingSystem.models.Account.*;
import com.example.BankingSystem.models.User.AccountHolder;
import com.example.BankingSystem.models.User.Admin;
import com.example.BankingSystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Service
public class AdminService {

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    SavingsRepository savingsRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CreditCardRepository creditCardRepository;


    public Account createCheckingAccount(CheckingDTO checkingDTO){
        AccountHolder primaryOwner = accountHolderRepository.findById(checkingDTO.getPrimaryOwnerId()).get();
        AccountHolder secondaryOwner = null;
        if(checkingDTO.getSecondaryOwnerId() !=null){
            secondaryOwner = accountHolderRepository.findById(checkingDTO.getSecondaryOwnerId()).get();
        }

        if(Period.between(primaryOwner.getDateOfBirth(), LocalDate.now()).getYears() < 24){
            Account studentChecking = new StudentChecking(checkingDTO.getBalance(), primaryOwner,
                    secondaryOwner, checkingDTO.getSecretKey());
            return accountRepository.save(studentChecking);
        }else{
            if(checkingDTO.getBalance().compareTo(new BigDecimal(250)) < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "balance must to be more than 250");
            }
            Account checking = new Checking(checkingDTO.getBalance(), primaryOwner,
                    secondaryOwner, checkingDTO.getSecretKey());
                    return accountRepository.save(checking);
        }
    }

    public Savings createSavingsAccount(Savings savings){
        return savingsRepository.save(savings);
    }

    public AccountHolder createAccountHolder (AccountHolder accountHolder){
        return accountHolderRepository.save(accountHolder);
    }

    public Admin createAdmin (Admin admin){
        return adminRepository.save(admin);
    }

    public Account updateBalance (UpdateBalanceDTO updateBalanceDTO){

        Account account = accountRepository.findById(updateBalanceDTO.getAccountId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The id is not in our system"));
        BigDecimal newBalance = updateBalanceDTO.getNewBalance();
        account.setBalance(newBalance);
        return accountRepository.save(account);
    }

    public CreditCard createCreditCard(CreditCard creditCard){

        return creditCardRepository.save(creditCard);
    }
}}
