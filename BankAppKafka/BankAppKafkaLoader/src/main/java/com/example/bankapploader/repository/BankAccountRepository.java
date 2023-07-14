package com.example.bankapploader.repository;

import com.example.bankapploader.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

//репозиторий для использования JPA фукнционала
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

}
