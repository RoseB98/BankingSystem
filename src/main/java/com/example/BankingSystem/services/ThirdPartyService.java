package com.example.BankingSystem.services;

import com.example.BankingSystem.DTOs.ThirdPartyDTO;
import com.example.BankingSystem.models.Account.Account;
import com.example.BankingSystem.models.Account.Transfer;
import com.example.BankingSystem.models.User.ThirdParty;
import com.example.BankingSystem.repositories.AccountRepository;
import com.example.BankingSystem.repositories.ThirdPartyRepository;
import com.example.BankingSystem.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class ThirdPartyService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransferRepository transferRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

  public void sendingMoneyToOtherAccount(ThirdPartyDTO thirdPartyDTO){
       Account receivingAccount = accountRepository.findById(thirdPartyDTO.getReceivingAccountId()).get();
      BigDecimal sendingAmount = thirdPartyDTO.getSendingAmount();
      receivingAccount.setBalance(receivingAccount.getBalance().add(sendingAmount));
      accountRepository.save(receivingAccount);
  }

  public void receivingMoneyFromOtherAccount(ThirdPartyDTO thirdPartyDTO){
      Account sendingAccount = accountRepository.findById(thirdPartyDTO.getSendingAccountId()).get();
      BigDecimal receivingAmount = thirdPartyDTO.getSendingAmount();
      sendingAccount.setBalance(sendingAccount.getBalance().subtract(receivingAmount));
      accountRepository.save(sendingAccount);
  }
    
}
