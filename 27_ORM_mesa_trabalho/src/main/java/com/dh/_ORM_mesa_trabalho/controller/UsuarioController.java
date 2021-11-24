package com.dh._ORM_mesa_trabalho.controller;

import com.dh._ORM_mesa_trabalho.persistence.entities.UsuarioEntity;
import com.dh._ORM_mesa_trabalho.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity <List<UsuarioEntity>> buscarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody UsuarioEntity usuarioEntity) {
        if(usuarioService.salvar(usuarioEntity) != null) {
            return ResponseEntity.ok("Salvo com sucessso");
        }
        return ResponseEntity.badRequest().body("Não foi possível salvar");
    }
}
