package com.example.BankingSystem.repositories;

import com.example.BankingSystem.models.Account.Checking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingRepository extends JpaRepository<Checking, Integer> {
}
