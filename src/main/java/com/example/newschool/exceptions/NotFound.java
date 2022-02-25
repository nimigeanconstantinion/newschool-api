package com.example.newschool.exceptions;

public class NotFound extends RuntimeException{
    private String message;
    public NotFound(String message){
        super(message);
    }
}
