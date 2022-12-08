package com.example.BankingSystem.services;

import com.example.BankingSystem.models.Account.Account;
import com.example.BankingSystem.models.Account.Savings;
import com.example.BankingSystem.repositories.AccountHolderRepository;
import com.example.BankingSystem.repositories.AccountRepository;
import com.example.BankingSystem.repositories.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Service
public class AccountHolderService {

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    SavingsRepository savingsRepository;

   /* public BigDecimal showBalance(Long id){
        return accountRepository.findById(id).get().getBalance();
    }*/

    //llamar al metodo de los intereses dentro del metodo showbalance(comprobando qie el id de la cuenta sea de savings) y si es savings llamarlo

    //crear variable de la ultima vez que se aplico el interes
    //editar lo del 365
    //lo que va dentro del multiply
    public Savings showSavingAccountBalance(Long id){
        Savings account = savingsRepository.findById(id).get();

        if (Period.between(account.getCreationDate(), LocalDate.now()).getDays() > 365){

            BigDecimal rateAndBalance = account.getBalance().multiply(new BigDecimal(0.0025));
            BigDecimal newBalance = account.getBalance().add(rateAndBalance);
            account.setBalance(newBalance);
        }
        return accountRepository.save(account);
    }

    public BigDecimal showBalance(Long id){
        return accountRepository.findById(id).get().getBalance();
    }
}
