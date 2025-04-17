package com.serviceimplementation;

import com.domain.Pelicula;
import com.repository.PeliculaRepository;
import com.service.PeliculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaRepository repo;

    @Override
    public List<Pelicula> listarTodas() {
        return repo.findAll();
    }

    @Override
    public Pelicula buscarPorId(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public void guardar(Pelicula p) {
        repo.save(p);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
