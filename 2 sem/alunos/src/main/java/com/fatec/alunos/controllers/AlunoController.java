package com.fatec.alunos.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.alunos.entities.Aluno;
import com.fatec.alunos.services.AlunoService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/alunos")

public class AlunoController {
    private final AlunoService service;

    public AlunoController (AlunoService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno){
        Aluno a = service.save(aluno);
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(a.getId())
                        .toUri();
        return ResponseEntity.created(location).body(a);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody Aluno aluno, @PathVariable Long id){
        service.Update(aluno, id);
        return ResponseEntity.noContent().build();
    }
    
    
}
