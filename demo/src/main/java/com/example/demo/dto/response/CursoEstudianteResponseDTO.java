package com.example.demo.dto.response;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiantes;

public record CursoEstudianteResponseDTO(
        Long id,
        Curso curso,
        Estudiantes estudiantes
) {
}
