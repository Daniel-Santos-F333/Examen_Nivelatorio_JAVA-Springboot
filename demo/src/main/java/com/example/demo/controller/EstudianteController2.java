package com.example.demo.controller;

import com.example.demo.dto.request.EstudianteRequestDTO;
import com.example.demo.dto.response.EstudianteResponseDTO;
import com.example.demo.service.impl.EstudianteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante")
@Validated
@RequiredArgsConstructor
public class EstudianteController2 {
    private final EstudianteServiceImpl estudianteService;
    @PostMapping
    public ResponseEntity<EstudianteResponseDTO> guardar(@Valid @RequestBody EstudianteRequestDTO dto) {
        System.out.println("rfedfdf");
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> actualizar(@Valid @RequestBody EstudianteRequestDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok().body(estudianteService.actualizar(dto, id));
    }

    @GetMapping
    public ResponseEntity<List<EstudianteResponseDTO>> listar() {
        return ResponseEntity.ok().body(estudianteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> listar(@PathVariable Long id) {
        return ResponseEntity.ok().body(estudianteService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estudianteService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
