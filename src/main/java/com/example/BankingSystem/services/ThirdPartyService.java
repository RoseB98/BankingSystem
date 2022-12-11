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

@Service
public class ThirdPartyService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransferRepository transferRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

  public void sendAndRecieve(ThirdPartyDTO thirdPartyDTO){

  }
    
}
