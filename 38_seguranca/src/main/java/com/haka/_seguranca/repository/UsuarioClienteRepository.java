package com.haka._seguranca.repository;

import com.haka._seguranca.model.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer> {
    UsuarioCliente findByUsername(String username);
}