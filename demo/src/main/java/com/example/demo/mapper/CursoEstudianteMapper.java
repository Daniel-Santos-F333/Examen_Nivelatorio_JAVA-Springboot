package com.example.demo.mapper;

import com.example.demo.dto.request.CursoEstudianteRequestDTO;
import com.example.demo.dto.response.CursoEstudianteResponseDTO;
import com.example.demo.model.Curso;
import com.example.demo.model.CursoEstudiante;
import com.example.demo.model.Estudiantes;
import org.springframework.stereotype.Component;

@Component
public class CursoEstudianteMapper {
    public CursoEstudianteResponseDTO entityToDTO(CursoEstudiante cursoEstudiante){
        if(cursoEstudiante==null) return null;
        return new CursoEstudianteResponseDTO(
                cursoEstudiante.getId(),
                cursoEstudiante.getCurso(),
                cursoEstudiante.getEstudiante()
        );
    }
    public CursoEstudiante DTOtoEntity(Curso curso, Estudiantes estudiantes){
        if(curso==null || estudiantes==null) return null;
        CursoEstudiante cursoEstudiante=new CursoEstudiante();
        cursoEstudiante.setEstudiante(estudiantes);
        cursoEstudiante.setCurso(curso);
        return cursoEstudiante;
    }
    public void updateEntityFromDTO(Curso curso, Estudiantes estudiantes, CursoEstudiante cursoEstudiante){
        if(curso==null || estudiantes==null) return;
        cursoEstudiante.setEstudiante(estudiantes);
        cursoEstudiante.setCurso(curso);
    }
}
