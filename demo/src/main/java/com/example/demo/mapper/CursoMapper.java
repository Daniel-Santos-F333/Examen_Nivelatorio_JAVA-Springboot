package com.example.demo.mapper;

import com.example.demo.dto.request.CursoRequestDTO;
import com.example.demo.dto.response.CursoResponseDTO;
import com.example.demo.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    public CursoResponseDTO entityToDTO(Curso curso){
        if(curso==null) return null;
        return new CursoResponseDTO(
                curso.getId(),
                curso.getNombre(),
                curso.getDescripcion(),
                curso.getFechaInicio(),
                curso.getActivo()
        );
    }
    public Curso DTOToEntity(CursoRequestDTO dto){
        if(dto==null) return null;
        Curso c=new Curso();
        c.setNombre(dto.nombre());
        c.setDescripcion(dto.descripcion());
        c.setActivo(dto.activo());
        c.setFechaInicio(dto.fechaInicio());
        return c;
    }
    public void updateEntityFromDTO(Curso curso, CursoRequestDTO dto){
        if(dto==null || curso==null) return;
        curso.setNombre(dto.nombre());
        curso.setDescripcion(dto.descripcion());
        curso.setActivo(dto.activo());
        curso.setFechaInicio(dto.fechaInicio());
    }
}
