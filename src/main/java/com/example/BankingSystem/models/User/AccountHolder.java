package com.example.BankingSystem.models.User;

import com.example.BankingSystem.models.Account.Account;
import com.example.BankingSystem.models.User.Address;
import com.example.BankingSystem.models.User.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
public class AccountHolder extends User {

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;

    @Embedded
    private Address primaryAddress;
    // tendras que hacer un override de los nombres de el embedable
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "mailing_street")),
            @AttributeOverride(name = "buildingNumber", column = @Column(name = "mailing_building")),
            @AttributeOverride(name = "floorAndDoor", column = @Column(name = "mailing_floorAndDoor")),
            @AttributeOverride(name = "placeType", column = @Column(name = "mailing_placeType")),
            @AttributeOverride(name = "city", column = @Column(name = "mailing_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "mailing_postalCode"))
    })
    private Address mailingAddress;


    @OneToMany(mappedBy = "primaryOwner")
    private List<Account> accountList = new ArrayList<>();

    // crear las listas de ACcounts para cerrar las relaciones (@Onetomany)

    public AccountHolder() {
    }



    public AccountHolder(String name, String email, String password, LocalDate dateOfBirth, Address primaryAddress, Address mailingAddress) {
        super(name, email, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    @Override
    public String toString() {
        return "AccountHolder{" +
                "dateOfBirth=" + dateOfBirth +
                ", primaryAddress=" + primaryAddress +
                ", mailingAddress=" + mailingAddress +
                '}';
    }
}
