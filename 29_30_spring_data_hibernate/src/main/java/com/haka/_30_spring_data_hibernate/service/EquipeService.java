package com.haka._30_spring_data_hibernate.service;

import com.haka._30_spring_data_hibernate.model.Equipe;
import com.haka._30_spring_data_hibernate.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository repository;

    public Equipe insert(Equipe equipe){
        return repository.save(equipe);
    }
}
