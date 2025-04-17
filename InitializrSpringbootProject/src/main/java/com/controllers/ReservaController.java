package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.domain.Reserva;
import com.service.ReservaService;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService service;
    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", service.listarTodas());
        return "reservas/list";
    }

    @GetMapping("/nueva")
    public String formulario(Reserva reserva) {
        return "reservas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Reserva reserva) {
        service.guardar(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/reservas";
    }
}
