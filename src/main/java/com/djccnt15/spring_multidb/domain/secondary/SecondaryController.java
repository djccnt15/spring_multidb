package com.djccnt15.spring_multidb.domain.secondary;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/secondary")
@RequiredArgsConstructor
public class SecondaryController {
    
    private final SecondaryService service;
    
    @PostMapping(path = "/data")
    public ResponseEntity<?> createData() {
        var data = service.createData();
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(data);
    }
    
    @GetMapping(path = "/data")
    public ResponseEntity<?> getData() {
        var data = service.getData();
        return ResponseEntity.ok(data);
    }
    
    @GetMapping(path = "/data/{id}")
    public ResponseEntity<?> getDatum(
        @PathVariable(value = "id") Long id
    ) {
        var datum = service.getDatum(id);
        return ResponseEntity.ok(datum);
    }
    
    @DeleteMapping(path = "/data/{id}")
    public ResponseEntity<?> deleteData(
        @PathVariable(value = "id") Long id
    ) {
        service.deleteData(id);
        return ResponseEntity.noContent().build();
    }
}
