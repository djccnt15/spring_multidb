package com.djccnt15.spring_multidb.db.secondary.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "dummy")
@Builder
public class DummyEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
