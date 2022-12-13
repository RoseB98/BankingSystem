package com.example.BankingSystem.controllers;

import com.example.BankingSystem.DTOs.ThirdPartyDTO;
import com.example.BankingSystem.services.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/third-party-area")
public class ThirdPartyController {

    @Autowired
    ThirdPartyService thirdPartyService;

    @PutMapping("/receive-money")
    public void recieveMoney(@RequestBody ThirdPartyDTO thirdPartyDTO){
        thirdPartyService.receivingMoneyFromOtherAccount(thirdPartyDTO);
    }

    @PutMapping("/send-money")
    public void sendMoney(@RequestBody ThirdPartyDTO thirdPartyDTO){
        thirdPartyService.sendingMoneyToOtherAccount(thirdPartyDTO);
    }
}
