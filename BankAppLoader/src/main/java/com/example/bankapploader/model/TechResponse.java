package com.example.bankapploader.model;

//класс для отображения успешности выполнения сервиса
public class TechResponse {

    private String result;
    private String errorDescription;

    public String getResult() {
        return result;
    }

    public void setResult(boolean bool) {
        if (bool) {
            this.result = "SUCCESS";
        } else {
            this.result = "ERROR";
        }
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
