package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record CursoRequestDTO(
        @NotBlank(message = "Error, debe rellenar el nombre")
        @Size(min = 2, max = 50, message = "Error, el nombre debe estar entre 2 y 50 caracteres")
        String nombre,
        String descripcion,
        Date fechaInicio,
        @NotNull(message = "Error, no puede ser nulo")
        Boolean activo
) {
}
