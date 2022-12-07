package com.example.BankingSystem.models.User;

import com.example.BankingSystem.models.User.User;
import jakarta.persistence.Entity;

@Entity
public class Admin extends User {

    public Admin() {
    }

    public Admin(String name, String email, String password) {
        super(name, email, password);
    }

}
