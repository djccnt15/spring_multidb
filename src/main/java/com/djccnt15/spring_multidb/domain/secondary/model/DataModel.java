package com.djccnt15.spring_multidb.domain.secondary.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DataModel {
    
    private Integer id;
    
    private LocalDateTime createdAt;
}
