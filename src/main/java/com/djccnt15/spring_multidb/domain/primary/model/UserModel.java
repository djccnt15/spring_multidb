package com.djccnt15.spring_multidb.domain.primary.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserModel {
    
    private Integer id;
    
    private String name;
    
    private String fullName;
    
    private LocalDateTime createdAt;
}
