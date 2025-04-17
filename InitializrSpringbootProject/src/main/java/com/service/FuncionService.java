package com.service;

import java.util.List;
import com.domain.Funcion;

public interface FuncionService {
    List<Funcion> listarTodas();
    Funcion buscarPorId(Long id);
    void guardar(Funcion f);
    void eliminar(Long id);
}
