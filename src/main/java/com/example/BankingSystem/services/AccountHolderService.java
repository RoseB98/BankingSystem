package com.example.BankingSystem.services;

import com.example.BankingSystem.models.Account.Account;
import com.example.BankingSystem.models.Account.CreditCard;
import com.example.BankingSystem.models.Account.Savings;
import com.example.BankingSystem.repositories.AccountHolderRepository;
import com.example.BankingSystem.repositories.AccountRepository;
import com.example.BankingSystem.repositories.CreditCardRepository;
import com.example.BankingSystem.repositories.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    //llamar al metodo de los intereses dentro del metodo showbalance(comprobando qie el id de la cuenta sea de savings) y si es savings(con instance of) llamarlo
    //crear variable de la ultima vez que se aplico el interes
    //editar lo del 365
    //lo que va dentro del multiply

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

}
