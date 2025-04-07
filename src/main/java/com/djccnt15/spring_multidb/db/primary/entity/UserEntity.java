package com.djccnt15.spring_multidb.db.primary.entity;

import com.djccnt15.spring_multidb.db.primary.entity.converter.LocalDateTimeConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_account")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "fullname")
    private String fullName;
    
    @Column(name = "created_at")
    @CreationTimestamp
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime createdAt;
}
