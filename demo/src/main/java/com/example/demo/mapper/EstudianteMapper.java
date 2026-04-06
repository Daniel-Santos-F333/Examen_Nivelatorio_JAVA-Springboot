package com.example.demo.mapper;

import com.example.demo.dto.request.EstudianteRequestDTO;
import com.example.demo.dto.response.EstudianteResponseDTO;
import com.example.demo.model.Estudiantes;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {
    public EstudianteResponseDTO entityToDTO(Estudiantes estudiantes) {
        if (estudiantes == null) return null;
        return new EstudianteResponseDTO(
                estudiantes.getId(),
                estudiantes.getNombre(),
                estudiantes.getEmail(),
                estudiantes.getEdad()
        );
    }

    public Estudiantes DTOToEntity(EstudianteRequestDTO dto) {
        if (dto == null) return null;
        Estudiantes e = new Estudiantes();
        e.setNombre(dto.nombre());
        e.setEmail(dto.email());
        e.setEdad(dto.edad());
        return e;
    }

    public void updateEntityFromDTO(Estudiantes estudiantes, EstudianteRequestDTO dto) {
        if (dto == null || estudiantes == null) return;
        estudiantes.setNombre(dto.nombre());
        estudiantes.setEmail(dto.email());
        estudiantes.setEdad(dto.edad());
    }
}
