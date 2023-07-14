package com.example.bankapploader.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "bankAccounts")
public class BankAccount {

    @Id
    @Column(name = "id")
    private UUID uuid;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "patronymie")
    private String patronymie;

    @Column(name = "accountNumber")
    private long accountNumber;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymie() {
        return patronymie;
    }

    public void setPatronymie(String patronymie) {
        this.patronymie = patronymie;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

}

