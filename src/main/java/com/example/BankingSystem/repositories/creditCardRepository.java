package com.example.BankingSystem.repositories;

import com.example.BankingSystem.models.Account.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface creditCardRepository extends JpaRepository<CreditCard, Integer> {
}
