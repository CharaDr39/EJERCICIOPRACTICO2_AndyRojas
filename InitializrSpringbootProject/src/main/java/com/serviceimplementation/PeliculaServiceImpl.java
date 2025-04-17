package com.serviceimplementation;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.PeliculaDao;
import com.domain.Pelicula;
import com.service.PeliculaService;
import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    private PeliculaDao dao;

    public List<Pelicula> listarTodas() { return dao.findAll(); }
    public Pelicula buscarPorId(Long id) { return dao.findById(id).orElse(null); }
    public void guardar(Pelicula p) { dao.save(p); }
    public void eliminar(Long id) { dao.deleteById(id); }
}
