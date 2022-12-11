package com.example.BankingSystem.models.User;

import com.example.BankingSystem.models.User.User;
import jakarta.persistence.Entity;

import java.util.Set;

@Entity
public class Admin extends User {

    public Admin() {
    }

    public Admin(String name, String password) {
        super(name, password);
    }
}
