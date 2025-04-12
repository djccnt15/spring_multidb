package com.djccnt15.spring_multidb.exception.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {
    
    private final Integer statusCode;
    
    public ApiException(String message) {
        super(message);
        this.statusCode = 500;
    }
    
    public ApiException(String message, Throwable ex) {
        super(message, ex);
        this.statusCode = 500;
    }
    
    public ApiException(HttpStatus status, String message) {
        super(message);
        this.statusCode = status.value();
    }
    
    public ApiException(HttpStatus status, String message, Throwable ex) {
        super(message, ex);
        this.statusCode = status.value();
    }
    
    public ApiException(Integer statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
    
    public ApiException(Integer statusCode, String message, Throwable ex) {
        super(message, ex);
        this.statusCode = statusCode;
    }
}
