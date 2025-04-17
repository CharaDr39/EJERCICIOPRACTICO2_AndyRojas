package com.controllers;

import com.domain.Funcion;
import com.service.FuncionService;
import com.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funciones")
public class FuncionController {

    private final FuncionService funcionService;
    private final PeliculaService peliculaService;

    public FuncionController(FuncionService funcionService,
                             PeliculaService peliculaService) {
        this.funcionService   = funcionService;
        this.peliculaService  = peliculaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("funciones", funcionService.listarTodas());
        return "funciones/list";
    }

    @GetMapping({"/nueva", "/editar/{id}"})
    public String formulario(@PathVariable(required = false) Long id,
                             Model model) {
        Funcion funcion = (id == null)
                          ? new Funcion()
                          : funcionService.buscarPorId(id);
        model.addAttribute("funcion", funcion);
        model.addAttribute("peliculas", peliculaService.listarTodas());
        return "funciones/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Funcion funcion) {
        funcionService.guardar(funcion);
        return "redirect:/funciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        funcionService.eliminar(id);
        return "redirect:/funciones";
    }
}
