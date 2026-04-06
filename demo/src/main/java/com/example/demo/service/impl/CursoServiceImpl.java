package com.example.demo.service.impl;

import com.example.demo.dto.request.CursoRequestDTO;
import com.example.demo.dto.response.CursoResponseDTO;
import com.example.demo.exception.BusinessRuleException;
import com.example.demo.mapper.CursoMapper;
import com.example.demo.model.Curso;
import com.example.demo.model.CursoEstudiante;
import com.example.demo.model.Estudiantes;
import com.example.demo.repository.CursoEstudianteRepository;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {
    private final CursoMapper cursoMapper;
    private final CursoRepository cursoRepository;
    private final EstudianteRepository estudianteRepository;
    private final CursoEstudianteRepository cursoEstudianteRepository;
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

    public void matricularEstudiante(Long cursoId, Long estudianteId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new BusinessRuleException("Error, curso no encontrado"));

        if (!curso.getActivo()) {
            throw new BusinessRuleException("Regla de negocio: No se puede matricular en un curso inactivo");
        }

        Estudiantes estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new BusinessRuleException("Error, estudiante no encontrado"));

        if (cursoEstudianteRepository.existsByCursoIdAndEstudianteId(cursoId, estudianteId)) {
            throw new BusinessRuleException("Regla de negocio: El estudiante ya está matriculado en este curso");
        }

        CursoEstudiante matricula = new CursoEstudiante();
        matricula.setCurso(curso);
        matricula.setEstudiante(estudiante);
        cursoEstudianteRepository.save(matricula);
    }

    @Override
    public void desmatricularEstudiante(Long cursoId, Long estudianteId) {
        CursoEstudiante matricula = cursoEstudianteRepository.findByCursoIdAndEstudianteId(cursoId, estudianteId)
                .orElseThrow(() -> new BusinessRuleException("Error, el estudiante no está matriculado en este curso"));

        cursoEstudianteRepository.delete(matricula);
    }
}
