package com.example.bankappgenerator.service;

import com.example.bankappgenerator.model.BankAccount;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class BankAccountService {

    //генерация случайного объекта BankAccount
    public BankAccount bankAccountGenerator() {

        BankAccount obj = new BankAccount();

        //генерация uuid
        obj.setUuid(UUID.randomUUID());

        //генерация пола и ФИО
        Random random = new Random();
        boolean sex = random.nextBoolean();
        if (sex) {
            obj.setFirstName(randomFileWord("MansNames.txt"));
            obj.setLastName(randomFileWord("MansSurnames.txt"));
            obj.setPatronymie(randomFileWord("MansPatronymics.txt"));
        } else {
            obj.setFirstName(randomFileWord("WomansNames.txt"));
            obj.setLastName(randomFileWord("WomansSurnames.txt"));
            obj.setPatronymie(randomFileWord("WOmansPatronymics.txt"));
        }

        //генерация номера аккаунта
        obj.setAccountNumber(random.nextLong(0, Long.MAX_VALUE));

        return obj;
    }

    //метод выбора случайного элемента ФИО
    private String randomFileWord (String fileName) {
        Random random = new Random();

        try {
            //файл из папки NamesForBankAccounts
            URL res = getClass().getClassLoader().getResource("NamesForBankAccounts/" + fileName);
            File file = Paths.get(res.toURI()).toFile();
            List<String> list = new ArrayList<>();

            //чтение строк из файла
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            list.add(line);
            while (line != null) {
                line = reader.readLine();
                list.add(line);
            }

            //выбор случайной строки
            int position = random.nextInt(list.size());
            return list.get(position);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
