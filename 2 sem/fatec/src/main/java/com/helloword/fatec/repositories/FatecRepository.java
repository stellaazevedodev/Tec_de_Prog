package com.helloword.fatec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.helloword.fatec.entities.Fatec;


public interface FatecRepository extends JpaRepository<Fatec, Long>{
    
}