package com.example.bankappgenerator.controller;

import com.example.bankappgenerator.model.BankAccount;
import com.example.bankappgenerator.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping(value = "/generate")
    public ResponseEntity<BankAccount> bankAccountGenerator() {
        BankAccount bankAccount = bankAccountService.bankAccountGenerator();
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }
}
