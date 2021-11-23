package com.dh._26_injecao_independencias_mesa_trabalho.controller;

import com.dh._26_injecao_independencias_mesa_trabalho.dao.PacienteDAO;
import com.dh._26_injecao_independencias_mesa_trabalho.model.Paciente;
import com.dh._26_injecao_independencias_mesa_trabalho.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/paciente")
public class PacienteController implements IController<Paciente, PacienteDAO>{

    @Autowired
    private PacienteService pacienteService;

    @Override
    public ResponseEntity<Map<Integer, Paciente>> getMethod() {
        return ResponseEntity.status(200).body(pacienteService.buscar());
    }

    @Override
    public ResponseEntity<String> deleteMethod(@PathVariable Integer id) {
        pacienteService.deletar(id);

        return ResponseEntity.ok("Deletado com sucesso");
    }

    @Override
    public ResponseEntity<Paciente> postMethod(@RequestBody PacienteDAO dao) {
        Paciente paciente = pacienteService.criar(dao);

        if (paciente == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(paciente);
    }

    @Override
    public ResponseEntity<Paciente> putMethod(@RequestBody PacienteDAO dao) {
        return ResponseEntity.status(200).body(pacienteService.editar(dao));
    }
}
