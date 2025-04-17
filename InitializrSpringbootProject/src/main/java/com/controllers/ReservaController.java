package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.domain.Reserva;
import com.service.ReservaService;
import com.service.FuncionService;  

@Controller
@RequestMapping("/reservas")
public class ReservaController {
    private final ReservaService reservaService;
    private final FuncionService funcionService;  

    public ReservaController(ReservaService reservaService, FuncionService funcionService) {
        this.reservaService = reservaService;
        this.funcionService = funcionService;    
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", reservaService.listarTodas());
        return "reservas/list";
    }

    @GetMapping("/nueva")
    public String formulario(Reserva reserva, Model model) {
        model.addAttribute("funciones", funcionService.listarTodas());  
        return "reservas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
        return "redirect:/reservas";
    }
}
