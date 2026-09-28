package com.fatec.futebol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.futebol.entities.Time;

public interface TimesRepository extends JpaRepository<Time, Long>{
    
}