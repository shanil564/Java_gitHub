package com.example.springBoot.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DuplicateUserException extends RuntimeException{
    private static final long serialVersionUID = 2L;
    public DuplicateUserException(String message) {
        super(message);
    }
}
