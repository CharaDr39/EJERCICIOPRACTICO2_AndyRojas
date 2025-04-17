package com.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity 
@Table(name = "reservas")
@Data @NoArgsConstructor @AllArgsConstructor
public class Reserva {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private int cantidadEntradas;

    @ManyToOne
    @JoinColumn(name = "funcion_id")
    private Funcion funcion;
}
