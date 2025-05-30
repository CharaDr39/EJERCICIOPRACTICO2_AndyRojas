package com.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity 
@Table(name = "peliculas")
@Data @NoArgsConstructor @AllArgsConstructor
public class Pelicula {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private int duracion; // minutos
}
