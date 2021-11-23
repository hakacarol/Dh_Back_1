package com.dh._ORM.controller;

import com.dh._ORM.persistence.entities.MovimentoEntity;
import com.dh._ORM.service.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovimentoController {

    @Autowired
    private MovimentoService service;

    @GetMapping
    public ResponseEntity <List<MovimentoEntity>> buscarTodos() {
        return ResponseEntity.ok(service.obterTodos());
    }

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody MovimentoEntity movimento) {
        if(service.save(movimento) != null){
            return ResponseEntity.ok("Salvo com sucesso");
        }
        return ResponseEntity.badRequest().body("Nao foi possivel salvar");
    }
}
