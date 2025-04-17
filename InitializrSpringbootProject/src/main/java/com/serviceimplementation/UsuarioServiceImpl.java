// src/main/java/com/serviceimplementation/UsuarioServiceImpl.java
package com.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domain.Usuario;
import com.repository.UsuarioRepository;
import com.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repo;

    @Override
    public List<Usuario> listarTodas() {
        return repo.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + id));
    }

    @Override
    public void guardar(Usuario usuario) {
        repo.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
