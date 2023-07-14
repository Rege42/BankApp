package com.example.bankapploader.service;

import com.example.bankapploader.model.BankAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Service
public class KafkaConsumerService {

    private static final String TOPIC = "bank-account-topic";

    private static final String groupId = "bankAccountLoader";

    private CompletableFuture<BankAccount> latestBankAccountFuture = new CompletableFuture<>();

    //слушатель сообщения от генератора
    @KafkaListener(topics = TOPIC, groupId = groupId)
    private void consume(ConsumerRecord<String,String> record) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        setLatestBankAccount(objectMapper.readValue(record.value(), BankAccount.class));
        System.out.println("Received message: " + record.value());
    }

    public synchronized void setLatestBankAccount(BankAccount bankAccount) {
        latestBankAccountFuture.complete(bankAccount);
        latestBankAccountFuture = new CompletableFuture<>();
    }

    public BankAccount getLatestBankAccount() throws ExecutionException, InterruptedException {
        return latestBankAccountFuture.get();
    }
}
