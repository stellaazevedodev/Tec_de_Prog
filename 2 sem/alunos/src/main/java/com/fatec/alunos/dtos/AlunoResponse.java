package com.fatec.alunos.dtos;

public record AlunoResponse(Long id, String nome, String cpf, String email, String telefone, String curso, Integer idade) {

} 
