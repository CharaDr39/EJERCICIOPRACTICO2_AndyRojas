package com.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity @Table(name = "usuarios")
@Data @NoArgsConstructor @AllArgsConstructor
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_roles",
      joinColumns = @JoinColumn(name = "usuario_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
