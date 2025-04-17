package com.service;

import java.util.List;
import com.domain.Pelicula;

public interface PeliculaService {
    List<Pelicula> listarTodas();
    Pelicula buscarPorId(Long id);
    void guardar(Pelicula p);
    void eliminar(Long id);
}
