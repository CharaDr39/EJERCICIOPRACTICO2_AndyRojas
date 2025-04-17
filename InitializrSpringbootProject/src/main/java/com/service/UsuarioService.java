package com.service;

import java.util.List;
import com.domain.Usuario;

public interface UsuarioService {
    List<Usuario> listarTodas();
    Usuario buscarPorId(Long id);
    void guardar(Usuario usuario);
    void eliminar(Long id);
}
