package com.helloword.fatec.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.helloword.fatec.entities.Fatec;
import com.helloword.fatec.repositories.FatecRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class fatecService {

    private final FatecRepository repository;

    public fatecService(FatecRepository repository) {
        this.repository = repository;
    }

    public List<Fatec> findAll() {
        return repository.findAll();
    }

    public Fatec findById(Long id) {
        return repository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException());
    }

    public void deleteById (Long id){

        if (repository.existsById(id))
            repository.deleteById(id);
        else
            throw new EntityNotFoundException("Escola não cadastrada");
    }

    public Fatec save(Fatec fatec){
        return repository.save(fatec);
    }

    public void Update(Fatec fatec, Long id){
        Fatec f = repository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Fatec não encontrada"));

        f.setDescription(fatec.getDescription());
        f.setName(fatec.getName());
        f.setPrice(fatec.getPrice());

        repository.save(f);

    }

}
