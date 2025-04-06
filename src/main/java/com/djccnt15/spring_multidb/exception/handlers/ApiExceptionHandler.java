package com.djccnt15.spring_multidb.exception.handlers;

import com.djccnt15.spring_multidb.common.Result;
import com.djccnt15.spring_multidb.exception.exceptions.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE)
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<?> exception(ApiException exception) {
        log.error("", exception);

        return ResponseEntity
            .status(exception.getStatusCode())
            .body(Result.builder()
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build()
            );
    }
}
