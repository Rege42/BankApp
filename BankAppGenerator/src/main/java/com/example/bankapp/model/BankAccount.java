package com.example.bankapp.model;

import java.util.UUID;

public class BankAccount {

    private UUID uuid;
    private String firstName;
    private String lastName;
    private String patronymie;
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
