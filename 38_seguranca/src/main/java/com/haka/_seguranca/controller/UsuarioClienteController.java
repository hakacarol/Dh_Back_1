package com.haka._seguranca.controller;

import com.haka._seguranca.model.UsuarioCliente;
import com.haka._seguranca.service.UsuarioClienteService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("usuario-cliente")
public class UsuarioClienteController {

    @Autowired
    private UsuarioClienteService service;

    @PostMapping("/jwt")
    public UsuarioCliente postUsuarioCliente(@RequestBody UsuarioCliente user) {
        return service.insertUsuarioCliente(user);
    }

    @GetMapping
    public String getJWT(@RequestBody UsuarioCliente user){

        UsuarioCliente usuarioCliente = service.checkUsuarioCliente(user);
        if(usuarioCliente != null) {

            String KEY = "chave_jwt";
            // pegará o tempo real em milisegundos
            Long timer = System.currentTimeMillis();
            String jwt = Jwts.builder()
                    // definição do formato e nome
                    .signWith(SignatureAlgorithm.HS256, KEY)
                    .setSubject(usuarioCliente.getUsername())
                    // inicio
                    .setIssuedAt(new Date(timer))
                    // quantidade de tempo / fim
                    .setExpiration(new Date(timer + 90000))
                    .claim(KEY, usuarioCliente)
                    .compact();

            return jwt;
        }
        return "usuario não existe";
    }

}
