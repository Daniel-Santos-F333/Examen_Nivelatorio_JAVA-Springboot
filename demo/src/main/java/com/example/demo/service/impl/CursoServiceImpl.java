package com.example.demo.service.impl;

import com.example.demo.dto.request.CursoRequestDTO;
import com.example.demo.dto.response.CursoResponseDTO;
import com.example.demo.exception.BusinessRuleException;
import com.example.demo.mapper.CursoMapper;
import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import com.example.demo.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {
    private final CursoMapper cursoMapper;
    private final CursoRepository cursoRepository;
    @Override
    public List<CursoResponseDTO> listarTodos() {
        return cursoRepository.findAll().stream().map(cursoMapper::entityToDTO).toList();
    }

    @Override
    public CursoResponseDTO buscarPorId(Long id) {
        Curso curso=cursoRepository.findById(id).orElseThrow(()->new BusinessRuleException("Error, curso no encontrado"));
        return cursoMapper.entityToDTO(curso);
    }

    @Override
    public CursoResponseDTO crear(CursoRequestDTO dto) {
        Curso curso=cursoMapper.DTOToEntity(dto);
        return cursoMapper.entityToDTO(cursoRepository.save(curso));
    }

    @Override
    public CursoResponseDTO actualizar(CursoRequestDTO dto, Long id) {
        Curso curso=cursoRepository.findById(id).orElseThrow(()->new BusinessRuleException("Error, curso no encontrado"));
        cursoMapper.updateEntityFromDTO(curso, dto);
        return cursoMapper.entityToDTO(cursoRepository.save(curso));
    }

    @Override
    public void eliminar(Long id) {
        Curso curso=cursoRepository.findById(id).orElseThrow(()->new BusinessRuleException("Error, el curso a eliminar no existe"));
        cursoRepository.delete(curso);
    }
}
