package com.example.BankingSystem.services;

import com.example.BankingSystem.DTOs.CheckingDTO;
import com.example.BankingSystem.DTOs.SavingAndCreditCardDTO;
import com.example.BankingSystem.DTOs.UpdateBalanceDTO;
import com.example.BankingSystem.DTOs.UpdateStatusDTO;
import com.example.BankingSystem.models.Account.*;
import com.example.BankingSystem.models.User.AccountHolder;
import com.example.BankingSystem.models.User.Admin;
import com.example.BankingSystem.models.User.ThirdParty;
import com.example.BankingSystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

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
    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    StudentCheckingRepository studentCheckingRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;


    public Account createCheckingAccount(CheckingDTO checkingDTO) {
        AccountHolder primaryOwner = accountHolderRepository.findById(checkingDTO.getPrimaryOwnerId()).get();
        AccountHolder secondaryOwner = null;
        if (checkingDTO.getSecondaryOwnerId() != null) {
            secondaryOwner = accountHolderRepository.findById(checkingDTO.getSecondaryOwnerId()).get();
        }

        if (Period.between(primaryOwner.getDateOfBirth(), LocalDate.now()).getYears() < 24) {
            Account studentChecking = new StudentChecking(checkingDTO.getBalance(), primaryOwner,
                    secondaryOwner, checkingDTO.getSecretKey());
            return accountRepository.save(studentChecking);
        } else {
            if (checkingDTO.getBalance().compareTo(new BigDecimal(250)) < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "balance must to be more than 250");
            }
            Account checking = new Checking(checkingDTO.getBalance(), primaryOwner,
                    secondaryOwner, checkingDTO.getSecretKey());
            return accountRepository.save(checking);
        }
    }

    public Savings createSavingsAccount(SavingAndCreditCardDTO savingAndCreditCardDTO) {
        AccountHolder primaryOwner = accountHolderRepository.findById(savingAndCreditCardDTO.getPrimaryOwnerId()).get();
        AccountHolder secondaryOwner = null;
        if (savingAndCreditCardDTO.getSecondaryOwnerId() != null) {
            secondaryOwner = accountHolderRepository.findById(savingAndCreditCardDTO.getSecondaryOwnerId()).get();
        }

        Savings savingsAccount = new Savings(savingAndCreditCardDTO.getBalance(), primaryOwner, secondaryOwner, savingAndCreditCardDTO.getSecretKey());
        return savingsRepository.save(savingsAccount);
    }

    public CreditCard createCreditCard(SavingAndCreditCardDTO savingAndCreditCardDTO) {
        AccountHolder primaryOwner = accountHolderRepository.findById(savingAndCreditCardDTO.getPrimaryOwnerId()).get();
        AccountHolder secondaryOwner = null;
        if (savingAndCreditCardDTO.getSecondaryOwnerId() != null) {
            secondaryOwner = accountHolderRepository.findById(savingAndCreditCardDTO.getSecondaryOwnerId()).get();
        }

        CreditCard creditCard = new CreditCard(savingAndCreditCardDTO.getBalance(), primaryOwner, secondaryOwner);

        return creditCardRepository.save(creditCard);
    }

    public ThirdParty createThirdParty(ThirdParty thirdParty){
        return thirdPartyRepository.save(thirdParty);
    }

    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAccount(Long accountNumber) {

        if (accountRepository.findById(accountNumber).isPresent()) {
            accountRepository.deleteById(accountNumber);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "account number does not exist");
        }
    }

    public Account updateBalance(UpdateBalanceDTO updateBalanceDTO) {

        Account account = accountRepository.findById(updateBalanceDTO.getAccountId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The id is not in our system"));
        BigDecimal newBalance = updateBalanceDTO.getNewBalance();
        account.setBalance(newBalance);
        return accountRepository.save(account);
    }

    public Account updateAccountStatus(UpdateStatusDTO updateStatusDTO) {
        Account account = accountRepository.findById(updateStatusDTO.getAccountId()).get();
        if (account instanceof Checking) {
            Checking checking = (Checking) account;
            checking.setStatus(updateStatusDTO.getStatus());
            return accountRepository.save(checking);
        } else if (account instanceof StudentChecking) {
            StudentChecking studentChecking = (StudentChecking) account;
            studentChecking.setStatus(updateStatusDTO.getStatus());
            return accountRepository.save(studentChecking);
        } else if (account instanceof Savings) {
            Savings savings = (Savings) account;
            savings.setStatus(updateStatusDTO.getStatus());
            return accountRepository.save(savings);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account number does not exist");
        }
    }

    public List<Savings> findAllSavings(){
        return savingsRepository.findAll();
    }

    public List<CreditCard> findAllCreditCards(){
        return creditCardRepository.findAll();
    }

    public List<Checking> findAllCheckings(){
        return checkingRepository.findAll();
    }

    public List<StudentChecking> findAllStudentCheckings(){
        return studentCheckingRepository.findAll();
    }
}
