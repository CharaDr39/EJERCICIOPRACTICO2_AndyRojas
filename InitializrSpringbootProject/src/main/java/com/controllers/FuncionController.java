package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.domain.Funcion;
import com.service.FuncionService;

@Controller
@RequestMapping("/funciones")
public class FuncionController {
    private final FuncionService service;
    public FuncionController(FuncionService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("funciones", service.listarTodas());
        return "funciones/list";
    }

    @GetMapping("/nueva")
    public String formulario(Funcion funcion) {
        return "funciones/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Funcion funcion) {
        service.guardar(funcion);
        return "redirect:/funciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/funciones";
    }
}
