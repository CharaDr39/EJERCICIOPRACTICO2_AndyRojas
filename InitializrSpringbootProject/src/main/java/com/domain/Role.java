package com.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "roles")
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // p.ej. "ROLE_ADMIN", "ROLE_USER"
}
