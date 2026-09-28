package com.fatec.alunos.mappers;

import com.fatec.alunos.dtos.AlunoRequest;
import com.fatec.alunos.dtos.AlunoResponse;
import com.fatec.alunos.entities.Aluno;

public class AlunoMapper {
    //API -> BANCO
    public static Aluno toEntity(AlunoRequest request){
        Aluno aluno = new Aluno();
        aluno.setNome(request.nome());
        aluno.setCpf(request.cpf());
        aluno.setEmail(request.email());
        aluno.setTelefone(request.telefone());
        aluno.setCurso(request.curso());
        aluno.setIdade(request.idade());
        
        return aluno;
    }

    //BANCO -> API
    public static AlunoResponse toDTO(Aluno aluno){
        return new AlunoResponse(
            aluno.getId(),
            aluno.getNome(),
            aluno.getCpf(),
            aluno.getEmail(),
            aluno.getTelefone(),
            aluno.getCurso(),
            aluno.getIdade()
        );
    }
}
