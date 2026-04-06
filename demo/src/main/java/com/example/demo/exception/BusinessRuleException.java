package com.example.demo.exception;

public class BusinessRuleException extends RuntimeException{
    public BusinessRuleException(String mensaje){
        super(mensaje);
    }
}
