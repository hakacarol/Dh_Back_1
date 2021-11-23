package com.dh._ORM.service;


import com.dh._ORM.persistence.entities.MovimentoEntity;
import com.dh._ORM.persistence.repository.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentoService {

    @Autowired
    private MovimentoRepository repository;

    // criar método q traga tudo q tem no BD na tabela movimentos
    public List<MovimentoEntity> obterTodos() { // "SELECT * FROM TABELA_MOVIMENTOS"
        return repository.findAll();
    }

    // método para salvar
    public String save(MovimentoEntity movimento){
        if(repository.save(movimento)!= null) {
            return "Salvo com sucesso";
        }
        return null;
    }
}
