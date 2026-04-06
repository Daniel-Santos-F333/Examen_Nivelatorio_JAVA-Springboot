package com.example.demo.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CursoEstudianteRequestDTO(
        @NotNull(message = "Error, el curso no puede ser nulo")
        @Positive(message = "Error, el curso debe tener un codigo positivo")
        Long cursoId,
        @NotNull(message = "Error, el estudiante no puede ser nulo")
        @Positive(message = "Error, el estudiante debe tener un codigo positivo")
        Long estudianteId
) {
}
