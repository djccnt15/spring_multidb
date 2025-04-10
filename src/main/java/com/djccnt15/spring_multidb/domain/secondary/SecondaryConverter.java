package com.djccnt15.spring_multidb.domain.secondary;

import com.djccnt15.spring_multidb.annotations.Converter;
import com.djccnt15.spring_multidb.db.secondary.entity.DataEntity;
import com.djccnt15.spring_multidb.domain.secondary.model.DataModel;

@Converter
public class SecondaryConverter {
    
    public DataModel toResponse(DataEntity entity) {
        return DataModel.builder()
            .id(entity.getId())
            .createdAt(entity.getCreatedAt())
            .build();
    }
}
