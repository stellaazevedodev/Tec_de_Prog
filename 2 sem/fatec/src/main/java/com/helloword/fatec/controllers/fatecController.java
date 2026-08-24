package com.helloword.fatec.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.helloword.fatec.entities.Fatec;
import com.helloword.fatec.services.fatecService;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/fatec")

public class fatecController {
    private final fatecService service;

    public fatecController(fatecService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Fatec>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Fatec> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<Fatec> save(@RequestBody Fatec fatec){
        Fatec f = service.save(fatec);
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(f.getId())
                        .toUri();
        return ResponseEntity.created(location).body(f);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Fatec fatec){
        service.Update(fatec, id);
        return ResponseEntity.noContent().build();
    }
    
}
