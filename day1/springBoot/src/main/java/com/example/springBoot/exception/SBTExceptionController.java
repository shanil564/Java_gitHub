package com.example.springBoot.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SBTExceptionController {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException recordNotFoundException){
        return new ResponseEntity<>(recordNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = DuplicateUserException.class)
    public ResponseEntity<Object> exception(DuplicateUserException duplicateUserException){
        return new ResponseEntity<>(duplicateUserException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = InvalidUserException.class)
    public ResponseEntity<Object> exception(InvalidUserException invalidUserException){
        return new ResponseEntity<>(invalidUserException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
