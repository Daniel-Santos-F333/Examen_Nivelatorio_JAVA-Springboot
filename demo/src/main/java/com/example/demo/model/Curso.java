package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "cursos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Curso {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = true)
    private String descripcion;
    @Column(nullable = true, name = "fecha")
    private Date fechaInicio;
    @Column(nullable = false)
    private Boolean activo;
}
