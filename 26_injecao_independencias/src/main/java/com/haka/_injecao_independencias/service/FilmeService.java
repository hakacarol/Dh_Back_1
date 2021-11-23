package com.haka._injecao_independencias.service;

import com.haka._injecao_independencias.dao.FilmeDAO;
import com.haka._injecao_independencias.model.Filme;
import com.haka._injecao_independencias.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public Map<Integer, Filme> buscarFilmes() {

        return repository.selectAll();
    }

    public Map<Integer, Filme> buscarFilmePorId(Integer id) {

        return repository.select(id);
    }

    public String deletarFilme(Integer id) {

        repository.delete(id);

        return  "O filme doi deletado com sucesso";
    }

    public Map<Integer, Filme> criarFilme(FilmeDAO dao) {

        Filme filme = new Filme(dao.getNome(), dao.getClassificacao(), dao.getGenero(), dao.getDistribuidora());

        return repository.create(filme);
    }

    public Map<Integer, Filme> editarFilme(FilmeDAO dao) {

        Filme filme = new Filme(dao.getNome(), dao.getClassificacao(), dao.getGenero(), dao.getDistribuidora());

        return repository.update(filme, dao.getId());
    }
}
