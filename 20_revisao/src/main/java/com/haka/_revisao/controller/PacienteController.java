package com.haka._revisao.controller;

import com.haka._revisao.domain.Paciente;
import com.haka._revisao.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping("listar")
    public Map<Integer, Paciente> listarPacientes() {
        return service.buscarPacientes();
    }

    @GetMapping("criar")
    public  Paciente criarPaciente() {
        return service.criarPaciente();
    }

    @GetMapping("deletar")
    public String deletarPaciente(@PathVariable Integer id) {
        service.deletarPaciente(id);
        return "Paciente deletado";
    }
}
