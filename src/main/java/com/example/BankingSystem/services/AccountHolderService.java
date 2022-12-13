package com.example.BankingSystem.services;

import com.example.BankingSystem.models.Account.Account;
import com.example.BankingSystem.models.Account.CreditCard;
import com.example.BankingSystem.models.Account.Savings;
import com.example.BankingSystem.models.Account.Transfer;
import com.example.BankingSystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Service
public class AccountHolderService {

    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    SavingsRepository savingsRepository;

    @Autowired
    TransferRepository transferRepository;


    public BigDecimal addInterestSavnigs(Long id){
        Savings account = savingsRepository.findById(id).get();

        if (Period.between(account.getLastInterestAdded(), LocalDate.now()).getYears() > 1 ){

            BigDecimal rateAndBalance = account.getBalance().multiply(account.getInterestRate());
            BigDecimal newBalance = account.getBalance().add(rateAndBalance);
            account.setBalance(newBalance);
            account.setLastInterestAdded(LocalDate.now());
            savingsRepository.save(account);
        }
        return account.getBalance();
    }

    public BigDecimal addInterestCreditCard(Long id){
        CreditCard card = creditCardRepository.findById(id).get();

        if(Period.between(card.getLastInterestAdded(), LocalDate.now()).getMonths() > 1){
            BigDecimal rateAndBalance = card.getBalance().multiply(card.getInterestRate());
            BigDecimal newBalance = card.getBalance().add(rateAndBalance);
            card.setBalance(newBalance);
            card.setLastInterestAdded(LocalDate.now());
            creditCardRepository.save(card);
        }
        return card.getBalance();
    }

    public BigDecimal showBalance(Long id){
      Account account = accountRepository.findById(id).get();
        if(account instanceof Savings){
            return addInterestSavnigs(id);
        } else if (account instanceof CreditCard) {
            return addInterestCreditCard(id);
        } else {
            return accountRepository.findById(id).get().getBalance();
        }
    }

    public Transfer transferMoney(Transfer transfer){
        Account sendingAccount = accountRepository.findById(transfer.getSendingAccountId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "the user does not exist"));
        Account receivingAccount = accountRepository.findById(transfer.getReceivingAccountId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "the user does not exist"));

        if(sendingAccount.getBalance().compareTo(transfer.getTransferAmount()) > 0)throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Balance is not enough");

        if(transfer.getRecipientName().equals(receivingAccount.getPrimaryOwner().getName()) ||
                transfer.getRecipientName().equals(receivingAccount.getSecondaryOwner().getName())){
            sendingAccount.setBalance(sendingAccount.getBalance().subtract(transfer.getTransferAmount()));
            receivingAccount.setBalance(receivingAccount.getBalance().add(transfer.getTransferAmount()));
            accountRepository.save(sendingAccount);
            accountRepository.save(receivingAccount);
            return transferRepository.save(transfer);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The name of the recipient does not match");

    }

}
