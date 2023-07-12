package com.example.bankapploader.controller;

import com.example.bankapploader.model.BankAccount;
import com.example.bankapploader.model.TechResponse;
import com.example.bankapploader.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping(value = "/load")
    public ResponseEntity<TechResponse> bankAccountLoader() {
        TechResponse techResponse = bankAccountService.bankAccountLoader();
        return new ResponseEntity<>(techResponse, HttpStatus.OK);
    }
}
