package com.djccnt15.spring_multidb.common;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Result {
    
    private final String message;
    
    private final LocalDateTime timestamp;
}
