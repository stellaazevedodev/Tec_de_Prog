package com.fatec.alunos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fatec.alunos.entities.Aluno;
import com.fatec.alunos.repository.AlunosRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlunoService {
    private final AlunosRepository repository;

    public AlunoService (AlunosRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> findAll(){
        return repository.findAll();
    }

    public Aluno findById(Long id){
        return repository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException());
    }

    public void deleteById(Long id){
        if (repository.existsById(id))
            repository.deleteById(id);
        else 
            throw new EntityNotFoundException("Aluno não cadastrado");
    }

    public Aluno save(Aluno aluno){
        return repository.save(aluno);
    }

    public void Update(Aluno aluno, Long id){
        Aluno a = repository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        a.setNome(aluno.getNome());
        a.setCpf(aluno.getCpf());
        a.setEmail(aluno.getEmail());
        a.setCurso(aluno.getCurso());
        a.setTelefone(aluno.getTelefone());
        a.setIdade(aluno.getIdade());

        repository.save(a);
    }

    
}
