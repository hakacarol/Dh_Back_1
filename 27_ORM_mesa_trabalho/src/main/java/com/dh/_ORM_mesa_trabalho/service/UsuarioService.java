package com.dh._ORM_mesa_trabalho.service;

import com.dh._ORM_mesa_trabalho.persistence.entities.UsuarioEntity;
import com.dh._ORM_mesa_trabalho.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public String salvar(UsuarioEntity usuarioEntity) {
        usuarioRepository.save(usuarioEntity);
        return "Salvo com sucesso!";
    }
}
