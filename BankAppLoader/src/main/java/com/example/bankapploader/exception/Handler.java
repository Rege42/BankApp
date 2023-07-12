package com.example.bankapploader.exception;

import com.example.bankapploader.model.TechResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {

    //проверка успешности вызова
    @ExceptionHandler(Exception.class)
    public ResponseEntity<TechResponse> handleException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        TechResponse techResponse = new TechResponse();
        techResponse.setResult(false);
        techResponse.setErrorDescription("Вызываемый метод недоступен или не существует");
        return new ResponseEntity<>(techResponse, HttpStatus.OK);
    }

}
