package com.haka._30_spring_data_hibernate.controller;

import com.haka._30_spring_data_hibernate.model.Treinador;
import com.haka._30_spring_data_hibernate.service.TreinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("treinador")
public class TreinadorController {
    @Autowired
    private TreinadorService service;

    @PostMapping
    public Treinador postTreinador(@RequestBody Treinador treinador){
        return service.insert(treinador);
    }
}
