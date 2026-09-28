package com.fatec.alunos.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AlunoRequest(
    @NotBlank(message = "Nome obrigatório") String nome, 
    @NotBlank (message = "cpf obrigatório") @Pattern (regexp = "\\d{11}") String cpf, 
    @Email(message = "Por favor, forneça um endereço de e-mail válido") String email, 
    @NotBlank (message = "Telefone obrigatório") @Pattern (regexp = "\\d{11}") String telefone, 
    @NotBlank (message = "Curso obrigatório") String curso, 
    @NotNull Integer idade
) {

} 

