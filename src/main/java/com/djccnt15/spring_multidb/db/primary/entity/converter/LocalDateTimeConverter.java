package com.djccnt15.spring_multidb.db.primary.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Converter
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, String> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public String convertToDatabaseColumn(LocalDateTime localDateTime) {
        return (localDateTime == null) ? null : localDateTime.format(FORMATTER);
    }
    
    @Override
    public LocalDateTime convertToEntityAttribute(String dbData) {
        return (dbData == null || dbData.isEmpty()) ? null : LocalDateTime.parse(dbData, FORMATTER);
    }
}
