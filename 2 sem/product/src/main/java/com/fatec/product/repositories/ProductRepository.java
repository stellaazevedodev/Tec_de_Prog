package com.fatec.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fatec.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    // repository armazena os dados da entidade Product, e o Long é o tipo do id da entidade
    // Repository é como uma ponta entre a aplicação e o banco de dados, ele é responsável por fazer a comunicação entre os dois
}
