package com.example.BankingSystem.services;

import com.example.BankingSystem.models.Account.Account;
import com.example.BankingSystem.models.Account.Checking;
import com.example.BankingSystem.models.Account.Savings;
import com.example.BankingSystem.models.Account.StudentChecking;
import com.example.BankingSystem.models.CheckingDTO;
import com.example.BankingSystem.models.User.AccountHolder;
import com.example.BankingSystem.models.User.User;
import com.example.BankingSystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            Account checking = new Checking(checkingDTO.getBalance(), primaryOwner,
                    secondaryOwner, checkingDTO.getSecretKey());
                    return accountRepository.save(checking);
        }
    }

    public Savings createSavingsAccount(Savings savings){
        return savingsRepository.save(savings);
    }
}
