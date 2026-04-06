package com.example.demo.dto.response;

import java.util.Date;

public record CursoResponseDTO(
        Long id,
        String nombre,
        String descripcion,
        Date fechaInicio,
        Boolean activo
) {
}
