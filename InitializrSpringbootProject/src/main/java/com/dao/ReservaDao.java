package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.domain.Reserva;

public interface ReservaDao extends JpaRepository<Reserva, Long> {}
