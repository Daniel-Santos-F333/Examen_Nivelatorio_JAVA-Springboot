package com.example.demo.dto.request;

import jakarta.validation.constraints.*;

public record EstudianteRequestDTO(
        @NotBlank(message = "Error, debe rellenar el nombre")
        @Size(min = 2, max = 50, message = "Error, el nombre debe estar entre 2 y 50 caracteres")
        String nombre,
        @Email(message = "Error email invalido!")
        @NotBlank(message = "Error, debe rellenar el email")
        @Size(min = 2, max = 200, message = "Error, el email debe estar entre 2 y 200 caracteres")
        String email,
        @NotNull(message = "Error, la edad no puede ser nula")
        @Max(value = 120, message = "Error, la edad maxima es 120")
        @Min(value = 18, message = "Error, la edad minima es 18")
        @Positive(message = "Error, no se aceptan edades negativas")
        Integer edad
) {
}
