package com.fatec.alunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.alunos.entities.Aluno;

public interface AlunosRepository extends JpaRepository<Aluno, Long>{

    
} 
