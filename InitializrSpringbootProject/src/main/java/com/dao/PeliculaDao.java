package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.domain.Pelicula;

public interface PeliculaDao extends JpaRepository<Pelicula, Long> {}
