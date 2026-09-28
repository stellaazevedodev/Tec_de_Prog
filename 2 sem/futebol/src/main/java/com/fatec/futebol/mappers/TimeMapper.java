package com.fatec.futebol.mappers;

import com.fatec.futebol.dtos.TimeRequest;
import com.fatec.futebol.dtos.TimeResponse;
import com.fatec.futebol.entities.Time;

public class TimeMapper {

    public static Time toEntity(TimeRequest request) {
        Time time = new Time();
        time.setNome(request.nome());
        time.setCidade(request.cidade());
        time.setEstado(request.estado());
        time.setTecnico(request.tecnico());
        time.setEstadio(request.estadio());
        return time;
    }

    public static TimeResponse toDTO(Time time) {
        return new TimeResponse(time.getId(), time.getNome(), time.getCidade(), time.getEstado(), time.getTecnico(), time.getEstadio());
    }
}
