package com.example.demo.repository;

import com.example.demo.model.CursoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CursoEstudianteRepository extends JpaRepository<CursoEstudiante, Long> {
    boolean existsByCursoIdAndEstudianteId(Long cursoId, Long estudianteId);
    Optional<CursoEstudiante> findByCursoIdAndEstudianteId(Long cursoId, Long estudianteId);
}
