package com.haka._30_spring_data_hibernate.service;


import com.haka._30_spring_data_hibernate.model.Treinador;
import com.haka._30_spring_data_hibernate.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinadorService {

    @Autowired
    private TreinadorRepository repository ;

    public Treinador insert(Treinador treinador){
        return repository.save(treinador);
    }
}
