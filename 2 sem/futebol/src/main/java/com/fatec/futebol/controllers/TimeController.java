package com.fatec.futebol.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.futebol.dtos.TimeRequest;
import com.fatec.futebol.dtos.TimeResponse;
import com.fatec.futebol.services.TimeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/times")
public class TimeController {

    private final TimeService service;

    public TimeController(TimeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TimeResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping ("{id}")
    public ResponseEntity<TimeResponse>getById(@PathVariable long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        service.deleteTime(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping 
    public ResponseEntity<TimeResponse> save(@Valid @RequestBody TimeRequest time){

        TimeResponse t = service.save(time);
        
        URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(t.id())
                    .toUri();
        
        return ResponseEntity.created(location).body(t);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @Valid @RequestBody TimeRequest time){

        service.update(time, id);
        return ResponseEntity.noContent().build();
    }
}
