package com.serviceimplementation;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.FuncionDao;
import com.domain.Funcion;
import com.service.FuncionService;
import java.util.List;

@Service
public class FuncionServiceImpl implements FuncionService {
    @Autowired
    private FuncionDao dao;

    public List<Funcion> listarTodas() { return dao.findAll(); }
    public Funcion buscarPorId(Long id) { return dao.findById(id).orElse(null); }
    public void guardar(Funcion f) { dao.save(f); }
    public void eliminar(Long id) { dao.deleteById(id); }
}
