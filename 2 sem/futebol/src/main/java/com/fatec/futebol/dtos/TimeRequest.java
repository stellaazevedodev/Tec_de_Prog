package com.fatec.futebol.dtos;

import jakarta.validation.constraints.NotBlank;

public record TimeRequest(@NotBlank String nome, @NotBlank String cidade, @NotBlank String estado, @NotBlank String tecnico, @NotBlank String estadio) {
    
}
