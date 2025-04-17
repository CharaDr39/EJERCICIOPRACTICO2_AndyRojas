package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.domain.Pelicula;
import com.service.PeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
    private final PeliculaService service;
    public PeliculaController(PeliculaService s){ this.service = s; }

    @GetMapping
    public String listar(Model m) {
        m.addAttribute("peliculas", service.listarTodas());
        return "peliculas/list";
    }

    @GetMapping("/nuevo")
    public String formulario(Pelicula p) {
        return "peliculas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Pelicula p) {
        service.guardar(p);
        return "redirect:/peliculas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/peliculas";
    }
}
