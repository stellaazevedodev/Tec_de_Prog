package com.fatec.alunos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fatec.alunos.dtos.AlunoRequest;
import com.fatec.alunos.dtos.AlunoResponse;
import com.fatec.alunos.entities.Aluno;
import com.fatec.alunos.mappers.AlunoMapper;
import com.fatec.alunos.repository.AlunosRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlunoService {
    private final AlunosRepository repository;

    public AlunoService (AlunosRepository repository) {
        this.repository = repository;
    }

    public List<AlunoResponse> findAll(){
        return repository.findAll()
                        .stream()
                        .map(AlunoMapper::toDTO)
                        .toList();
    }

    public AlunoResponse findById(Long id){
        return repository.findById(id)
                        .map(AlunoMapper::toDTO)
                        .orElseThrow(() -> new EntityNotFoundException());
    }

    public void deleteById(Long id){
        if (repository.existsById(id))
            repository.deleteById(id);
        else 
            throw new EntityNotFoundException("Aluno não cadastrado");
    }

    public AlunoResponse save(AlunoRequest aluno){
        Aluno salvo = repository.save(AlunoMapper.toEntity(aluno));
        return AlunoMapper.toDTO(salvo);
    }

    public void Update(AlunoRequest aluno, Long id){
        Aluno a = repository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
        a.setNome(aluno.nome());
        a.setCpf(aluno.cpf());
        a.setEmail(aluno.email());
        a.setCurso(aluno.curso());
        a.setTelefone(aluno.telefone());
        a.setIdade(aluno.idade());

        repository.save(a);
    }

    
}
