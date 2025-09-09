package com.djccnt15.spring_multidb.domain.secondary;

import com.djccnt15.spring_multidb.db.secondary.entity.DataEntity;
import com.djccnt15.spring_multidb.db.secondary.repository.DataRepository;
import com.djccnt15.spring_multidb.domain.secondary.model.DataModel;
import com.djccnt15.spring_multidb.exception.exceptions.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SecondaryService {
    
    private final DataRepository repository;
    private final SecondaryConverter converter;
    
    public DataModel createData() {
        var entity = DataEntity.builder().build();
        var data = repository.save(entity);
        return converter.toResponse(data);
    }
    
    public List<DataModel> getData() {
        var entityList = repository.findAll();
        return entityList.stream()
            .map(converter::toResponse)
            .toList();
    }
    
    @Transactional("secondaryTransactionManager")
    public DataModel getDatum(Long id) {
        var entity = repository.findById(id)
            .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "No Data"));
        return converter.toResponse(entity);
    }
    
    public void deleteData(Long id) {
        var entity = repository.findById(id)
            .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "No Data"));
        repository.delete(entity);
    }
}
