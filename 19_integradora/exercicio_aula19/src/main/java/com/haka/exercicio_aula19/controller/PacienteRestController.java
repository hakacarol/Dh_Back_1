package com.haka.exercicio_aula19.controller;

import com.haka.exercicio_aula19.domain.Paciente;
import com.haka.exercicio_aula19.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteRestController {

    @Autowired
    private PacienteService service;

    @GetMapping("listar")
    public List<Paciente> pacientes() {
        return service.listarPaciente();
    }

    @GetMapping("/email/{email}")
    public Paciente pacientePorEmail(@PathVariable String email) {
        return service.pacientePorEmail(email);
    }
}
