package com.meowsic.meows.exception;

import org.springframework.http.HttpStatus;

public class APIException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public APIException() {
        
    }

}
