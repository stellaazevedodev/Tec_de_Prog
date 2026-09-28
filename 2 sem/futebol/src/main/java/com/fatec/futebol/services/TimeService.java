package com.fatec.futebol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.futebol.dtos.TimeRequest;
import com.fatec.futebol.dtos.TimeResponse;
import com.fatec.futebol.entities.Time;
import com.fatec.futebol.mappers.TimeMapper;
import com.fatec.futebol.repository.TimesRepository;

import jakarta.persistence.EntityNotFoundException;

@Service 
public class TimeService {

    @Autowired
    private final TimesRepository repository;

    public TimeService(TimesRepository repository) {
        this.repository = repository;
    }

    public List<TimeResponse> findAll() {
        List<Time> times = repository.findAll();
        return times.stream()
                .map(TimeMapper::toDTO)
                .toList();
    }

    public TimeResponse getById(Long id) {
        return repository.findById(id)
                .map(TimeMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Time não encontrado com o ID: " + id));
    }

    public void deleteTime(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Time não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }

    public TimeResponse save(TimeRequest time){
        Time t = repository.save(TimeMapper.toEntity(time));
        return TimeMapper.toDTO(t);
    }

    public void update(TimeRequest time, Long id) {
        Time t = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Time não encontrado com o ID: " + id));

        t.setNome(time.nome());
        t.setCidade(time.cidade());
        t.setEstado(time.estado());
        t.setTecnico(time.tecnico());
        t.setEstadio(time.estadio());

        repository.save(t);
    }
    
}
