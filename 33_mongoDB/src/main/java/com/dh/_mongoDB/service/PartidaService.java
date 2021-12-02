package com.dh._mongoDB.service;

import com.dh._mongoDB.dao.PartidaDAO;
import com.dh._mongoDB.enums.Status;
import com.dh._mongoDB.model.Partida;
import com.dh._mongoDB.model.Time;
import com.dh._mongoDB.repository.PartidaRepository;
import com.dh._mongoDB.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;
    @Autowired
    private TimeRepository timeRepository;

    public Partida createPartida(PartidaDAO dao) {

        Partida partida = new Partida();

        Optional<Time> timeLocal = timeRepository.findById(dao.getIdTimeLocal());
        Optional<Time> timeVisitante = timeRepository.findById(dao.getIdTimeVisitante());

        partida.setStatus(Status.valueOf(dao.getStatus()));
        partida.setResultado(dao.getResultado());

        partida.setTimeLocal(timeLocal.get());
        partida.setTimeVisitante(timeVisitante.get());

        return partidaRepository.save(partida);
    }
}
