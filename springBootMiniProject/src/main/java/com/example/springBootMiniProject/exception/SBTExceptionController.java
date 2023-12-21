package com.example.springBootMiniProject.exception;


import com.example.springBootMiniProject.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SBTExceptionController {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException recordNotFoundException){
        Response response=new Response();
        response.setMessage(recordNotFoundException.getMessage());
        response.setStatus(false);
        response.setError(String.valueOf(HttpStatus.BAD_REQUEST));
        return ResponseEntity.ok(response);
    }
    @ExceptionHandler(value = DuplicateUserException.class)
    public ResponseEntity<Object> exception(DuplicateUserException duplicateUserException){
        Response response=new Response();
        response.setMessage(duplicateUserException.getMessage());
        response.setStatus(false);
        response.setError(String.valueOf(HttpStatus.BAD_REQUEST));
        return ResponseEntity.ok(response);
    }
    @ExceptionHandler(value = InvalidUserException.class)
    public ResponseEntity<Object> exception(InvalidUserException invalidUserException){
        Response response=new Response();
        response.setMessage(invalidUserException.getMessage());
        response.setStatus(false);
        response.setError(String.valueOf(HttpStatus.BAD_REQUEST));
        return ResponseEntity.ok(response);
    }
    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<Object> exception(BookNotFoundException bookNotFoundException){
        Response response=new Response();
        response.setMessage(bookNotFoundException.getMessage());
        response.setStatus(false);
        response.setError(String.valueOf(HttpStatus.BAD_REQUEST));
        return ResponseEntity.ok(response);
    }
}
