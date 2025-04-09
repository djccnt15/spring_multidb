package com.djccnt15.spring_multidb.domain.primary;

import com.djccnt15.spring_multidb.annotations.Converter;
import com.djccnt15.spring_multidb.db.primary.entity.UserEntity;
import com.djccnt15.spring_multidb.domain.primary.model.UserModel;
import com.djccnt15.spring_multidb.domain.primary.model.UserRequest;

@Converter
public class PrimaryConverter {
    
    public UserModel toResponse(UserEntity user) {
        return UserModel.builder()
            .id(user.getId())
            .name(user.getName())
            .fullName(user.getFullName())
            .createdAt(user.getCreatedAt())
            .build();
    }
    
    public UserEntity toEntity(UserRequest request) {
        return UserEntity.builder()
            .name(request.getName())
            .fullName(request.getFullName())
            .build();
    }
}
