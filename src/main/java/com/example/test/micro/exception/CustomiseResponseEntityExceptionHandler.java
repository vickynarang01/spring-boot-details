package com.example.test.micro.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomiseResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExcpetion(Exception ex, WebRequest request){
       return new ResponseEntity(new CustomExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false)),
               HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundExcpetion.class)
    public final ResponseEntity<Object> handleAllExcpetion(UserNotFoundExcpetion ex, WebRequest request){
        return new ResponseEntity(new CustomExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false)),
                HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request){
        return new ResponseEntity(new CustomExceptionResponse(new Date(), "Validation Failed", ex.getBindingResult().toString()),
                HttpStatus.BAD_REQUEST);
    }
}
