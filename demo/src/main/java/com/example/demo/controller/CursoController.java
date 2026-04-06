package com.example.demo.controller;

import com.example.demo.dto.request.CursoRequestDTO;
import com.example.demo.dto.response.CursoResponseDTO;
import com.example.demo.service.impl.CursoServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@Validated
@RequiredArgsConstructor
public class CursoController {
    private final CursoServiceImpl cursoService;
    @PostMapping
    public ResponseEntity<CursoResponseDTO> guardar(@Valid @RequestBody CursoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.crear(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> actualizar(@Valid @RequestBody CursoRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok().body(cursoService.actualizar(dto,id));
    }
    @GetMapping
    public ResponseEntity<List<CursoResponseDTO>> listar(){
        return ResponseEntity.ok().body(cursoService.listarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> listar(@PathVariable Long id){
        return ResponseEntity.ok().body(cursoService.buscarPorId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        cursoService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /**
    @PostMapping("/{id}/estudiante/{id2}")
    public ResponseEntity<Void> agregar_curso_estudiante(@PathVariable Long id, @PathVariable Long id2){

    }
    **/
}
