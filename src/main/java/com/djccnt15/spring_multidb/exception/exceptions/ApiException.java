package com.djccnt15.spring_multidb.exception.exceptions;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
    
    private final Integer statusCode;
    
    public ApiException(String message) {
        super(message);
        this.statusCode = 500;
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
