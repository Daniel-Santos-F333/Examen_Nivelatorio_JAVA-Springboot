package com.example.demo.service.impl;

import com.example.demo.dto.request.EstudianteRequestDTO;
import com.example.demo.dto.response.EstudianteResponseDTO;
import com.example.demo.exception.BusinessRuleException;
import com.example.demo.mapper.EstudianteMapper;
import com.example.demo.model.Estudiantes;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteMapper estudianteMapper;
    private final EstudianteRepository estudianteRepository;

    @Override
    public List<EstudianteResponseDTO> listarTodos() {
        return estudianteRepository.findAll().stream().map(estudianteMapper::entityToDTO).toList();
    }

    @Override
    public EstudianteResponseDTO buscarPorId(Long id) {
        Estudiantes estudiantes=estudianteRepository.findById(id).orElseThrow(()->new BusinessRuleException("Error, estudiante no encontrado"));
        return estudianteMapper.entityToDTO(estudiantes);
    }

    @Override
    public EstudianteResponseDTO crear(EstudianteRequestDTO dto) {
        Estudiantes estudiantes=estudianteMapper.DTOToEntity(dto);

        return estudianteMapper.entityToDTO(estudianteRepository.save(estudiantes));
    }

    @Override
    public EstudianteResponseDTO actualizar(EstudianteRequestDTO dto, Long id) {
        Estudiantes estudiantes=estudianteRepository.findById(id).orElseThrow(()->new BusinessRuleException("Error, estudiante no encontrado"));
        estudianteMapper.updateEntityFromDTO(estudiantes, dto);
        return estudianteMapper.entityToDTO(estudianteRepository.save(estudiantes));
    }

    @Override
    public void eliminar(Long id) {
        Estudiantes estudiantes=estudianteRepository.findById(id).orElseThrow(()->new BusinessRuleException("Error, el estudiante a eliminar no existe"));
        estudianteRepository.delete(estudiantes);
    }
}
