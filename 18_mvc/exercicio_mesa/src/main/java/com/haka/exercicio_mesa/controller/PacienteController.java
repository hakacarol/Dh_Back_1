package com.haka.exercicio_mesa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {

    @GetMapping("/paciente")

    public String welcome(Model model) {
        model.addAttribute("nome", "Amora");
        return "index";
    }
}
