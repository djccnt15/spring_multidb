package com.djccnt15.spring_multidb.domain.primary;

import com.djccnt15.spring_multidb.domain.primary.model.UserModel;
import com.djccnt15.spring_multidb.domain.primary.model.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/primary")
@RequiredArgsConstructor
public class PrimaryController {
    
    private final PrimaryService service;
    
    @PostMapping(path = "/user")
    public ResponseEntity<?> createUser(
        @RequestBody UserRequest request
    ) {
        var user = service.createUser(request);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(user);
    }
    
    @GetMapping(path = "/users")
    public ResponseEntity<List<UserModel>> getUsers() {
        var userList = service.getUsers();
        return ResponseEntity.ok(userList);
    }
    
    @GetMapping(path = "/user/{id}")
    public ResponseEntity<UserModel> getUser(
        @PathVariable(value = "id") Integer id
    ) {
        var user = service.getUser(id);
        return ResponseEntity.ok(user);
    }
    
    @PutMapping(path = "/user/{id}")
    public ResponseEntity<?> updateUser(
        @PathVariable(value = "id") Integer id,
        @RequestBody UserRequest request
    ) {
        var user = service.updateUser(id, request);
        return ResponseEntity.ok(user);
    }
    
    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<?> deleteUser(
        @PathVariable(value = "id") Integer id
    ) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
