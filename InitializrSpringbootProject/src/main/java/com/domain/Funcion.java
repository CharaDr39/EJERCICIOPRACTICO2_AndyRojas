package com.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity 
@Table(name = "funciones")
@Data @NoArgsConstructor @AllArgsConstructor
public class Funcion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaHora;
    private String sala;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;
}
