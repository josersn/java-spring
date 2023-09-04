package com.backend.healthserviceasservice.application.core;

public class HandleException extends Exception{

    private String message;
    private String code;


    public HandleException(String code, String message) {
        super(code);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
