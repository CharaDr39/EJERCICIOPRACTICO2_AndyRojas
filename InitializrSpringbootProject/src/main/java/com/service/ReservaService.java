package com.service;

import java.util.List;
import com.domain.Reserva;

public interface ReservaService {
    List<Reserva> listarTodas();
    Reserva buscarPorId(Long id);
    void guardar(Reserva r);
    void eliminar(Long id);
}
