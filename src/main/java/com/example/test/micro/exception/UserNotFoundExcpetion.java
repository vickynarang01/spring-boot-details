package com.example.test.micro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExcpetion extends RuntimeException {
    public UserNotFoundExcpetion(String s) {
        super(s);
    }
}
