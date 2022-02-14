package com.haka._seguranca.service;

import com.haka._seguranca.model.UsuarioCliente;
import com.haka._seguranca.repository.UsuarioClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioClienteService {

    @Autowired
    private UsuarioClienteRepository repository;

    public UsuarioCliente insertUsuarioCliente(UsuarioCliente user){
        UsuarioCliente usuarioCliente = new UsuarioCliente(user.getUsername(), user.getPassword(), user.getEmail());

        return repository.save(usuarioCliente);
    }

    public  UsuarioCliente checkUsuarioCliente(UsuarioCliente user){
        UsuarioCliente usuarioCliente = repository.findByUsername(user.getUsername());

        return usuarioCliente;
    }
}
