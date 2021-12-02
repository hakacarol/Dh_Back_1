package com.haka.checkpoint2.controller;

import com.haka.checkpoint2.persistence.entity.PacienteEntity;
import com.haka.checkpoint2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteEntity> postPaciente(@RequestBody PacienteEntity pacienteEntity){
        return ResponseEntity.ok(pacienteService.insert(pacienteEntity));
    }

    @GetMapping
    public ResponseEntity<List<PacienteEntity>> getPacientes() {

        return ResponseEntity.ok(pacienteService.selectAll());
    }

    @PutMapping("{id}/{email}")
    public ResponseEntity<PacienteEntity> putPaciente(@PathVariable Integer id, @PathVariable String email) {
        PacienteEntity pacienteEntity = pacienteService.update(id, email);
        if(pacienteEntity == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(pacienteEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Integer id) {
        String resultado = pacienteService.delete(id);
        if(resultado == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(resultado);
    }
}