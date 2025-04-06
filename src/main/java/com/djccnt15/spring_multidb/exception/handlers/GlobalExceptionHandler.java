package com.djccnt15.spring_multidb.exception.handlers;

import com.djccnt15.spring_multidb.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MAX_VALUE)
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity<?> exception(NoResourceFoundException exception) {
        return ResponseEntity.notFound().build();
    }
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> exception(Exception exception) {
        log.error("", exception);
        
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Result.builder()
                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .timestamp(LocalDateTime.now())
                .build()
            );
    }
}
