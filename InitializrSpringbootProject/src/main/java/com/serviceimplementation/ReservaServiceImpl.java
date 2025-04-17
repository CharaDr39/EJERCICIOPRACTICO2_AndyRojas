package com.serviceimplementation;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.ReservaDao;
import com.domain.Reserva;
import com.service.ReservaService;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaDao dao;

    public List<Reserva> listarTodas() { return dao.findAll(); }
    public Reserva buscarPorId(Long id) { return dao.findById(id).orElse(null); }
    public void guardar(Reserva r) { dao.save(r); }
    public void eliminar(Long id) { dao.deleteById(id); }
}
