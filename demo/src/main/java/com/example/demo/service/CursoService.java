package com.example.demo.service;

import com.example.demo.dto.request.CursoRequestDTO;
import com.example.demo.dto.response.CursoResponseDTO;

import java.util.List;

public interface CursoService {
    List<CursoResponseDTO> listarTodos();
    CursoResponseDTO buscarPorId(Long id);
    CursoResponseDTO crear(CursoRequestDTO dto);
    CursoResponseDTO actualizar(CursoRequestDTO dto, Long id);
    void eliminar(Long id);
    void matricularEstudiante(Long cursoId, Long estudianteId);
    void desmatricularEstudiante(Long cursoId, Long estudianteId);
}
