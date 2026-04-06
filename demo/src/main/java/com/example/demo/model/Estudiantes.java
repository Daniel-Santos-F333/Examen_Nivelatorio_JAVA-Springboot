package com.example.demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estudiantes")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Estudiantes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Integer edad;
}
