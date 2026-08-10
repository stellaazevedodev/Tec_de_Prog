package com.fatec.product.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fatec.product.entities.Product;
import com.fatec.product.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

    private final ProductRepository repository;

    ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

     public Product findById(Long id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException());
    }
    
}
