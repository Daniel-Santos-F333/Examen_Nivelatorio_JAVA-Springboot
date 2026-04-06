package com.example.demo.dto.response;

public record EstudianteResponseDTO(
        Long id,
        String nombre,
        String email,
        Integer edad
) {
}
