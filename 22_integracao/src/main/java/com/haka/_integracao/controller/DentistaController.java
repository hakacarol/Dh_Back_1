package com.haka._integracao.controller;

import com.haka._integracao.dao.DentistaDao;
import com.haka._integracao.domain.Dentista;
import com.haka._integracao.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("dentista")
public class DentistaController {

    @Autowired // construi os news
    private DentistaService service;

    @PostMapping
    // public -> método
    public Dentista postDentista(@RequestBody DentistaDao dentistaDao) {
        return service.registrarDentista(dentistaDao);
    }

    @GetMapping("buscarDentista/{id}")
    public Dentista getDentistaId(@PathVariable("id") Integer id) {
        return service.buscarDentista(id);
    }

    @GetMapping("listarDentistas")
    public Map<Integer, Dentista> getDentistas() {
        return service.listarDentista();
    }

    @PutMapping
    public Dentista putDentista(@RequestBody DentistaDao dentistaDao) {
        return service.atualizarDentista(dentistaDao);
    }

    @DeleteMapping("dentista/{id}")
    public String deleteDentista(@PathVariable("id") Integer id) {
        return service.deletarDentista(id);
    }
}
