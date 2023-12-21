package com.example.springBoot.exception;

public class InvalidUserException  extends RuntimeException{
    private static final long serialVersionUID = 3L;
    public InvalidUserException(String message) {
        super(message);
    }
}
