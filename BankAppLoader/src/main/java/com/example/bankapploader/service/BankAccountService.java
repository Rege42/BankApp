package com.example.bankapploader.service;

import com.example.bankapploader.model.BankAccount;
import com.example.bankapploader.model.TechResponse;
import com.example.bankapploader.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankAccountService {

    private final RestTemplate restTemplate;

    @Autowired
    BankAccountRepository bankAccountRepository;

    //шаблон для использования RestAPI функционала
    public BankAccountService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    //метода загрузки сгенерированного банковского аккаунта в БД (PostgreSQL)
    public TechResponse bankAccountLoader() {

        TechResponse techResponse = new TechResponse();

        //вызов генератора аккаунтов через RestAPI
        String url = "http://localhost:8080/generate";
        BankAccount bankAccount = this.restTemplate.getForObject(url, BankAccount.class);

        //сохранение аккаунта в БД при помощи JPA
        bankAccountRepository.save(bankAccount);

        techResponse.setResult(true);
        return techResponse;
    }
}
