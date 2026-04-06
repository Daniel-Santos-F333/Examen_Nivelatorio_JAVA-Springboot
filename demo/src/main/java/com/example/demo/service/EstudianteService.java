package com.example.demo.service;



import com.example.demo.dto.request.EstudianteRequestDTO;
import com.example.demo.dto.response.EstudianteResponseDTO;

import java.util.List;

public interface EstudianteService {
    List<EstudianteResponseDTO> listarTodos();
    EstudianteResponseDTO buscarPorId(Long id);
    EstudianteResponseDTO crear(EstudianteRequestDTO dto);
    EstudianteResponseDTO actualizar(EstudianteRequestDTO dto, Long id);
    void eliminar(Long id);
}
