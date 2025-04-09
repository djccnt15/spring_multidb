package com.djccnt15.spring_multidb.domain.primary;

import com.djccnt15.spring_multidb.db.primary.repository.UserRepository;
import com.djccnt15.spring_multidb.domain.primary.model.UserModel;
import com.djccnt15.spring_multidb.domain.primary.model.UserRequest;
import com.djccnt15.spring_multidb.exception.exceptions.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrimaryService {
    
    private final UserRepository repository;
    private final PrimaryConverter converter;
    
    public UserModel createUser(UserRequest request) {
        var entity = converter.toEntity(request);
        var user = repository.save(entity);
        return converter.toResponse(user);
    }
    
    public List<UserModel> getUsers() {
        var userList = repository.findAll();
        return userList.stream()
            .map(converter::toResponse)
            .toList();
    }
    
    public UserModel getUser(Integer id) {
        var entity = repository.findById(id)
            .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "No User"));
        return converter.toResponse(entity);
    }
    
    public UserModel updateUser(Integer id, UserRequest request) {
        var entity = repository.findById(id)
            .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "No User"));
        Optional.ofNullable(request.getName()).ifPresent(entity::setName);
        Optional.ofNullable(request.getFullName()).ifPresent(entity::setFullName);
        var user = repository.save(entity);
        return converter.toResponse(user);
    }
    
    public void deleteUser(Integer id) {
        var entity = repository.findById(id)
            .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "No User"));
        repository.delete(entity);
    }
}
