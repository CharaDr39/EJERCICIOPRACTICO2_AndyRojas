package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.domain.Usuario;
public interface UsuarioDao extends JpaRepository<Usuario,Long> {
    Usuario findByUsername(String username);
}
