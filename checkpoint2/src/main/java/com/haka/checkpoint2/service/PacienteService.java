package com.haka.checkpoint2.service;

import com.haka.checkpoint2.persistence.entity.PacienteEntity;
import com.haka.checkpoint2.persistence.repository.PacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    private static final Logger logger = Logger.getLogger(PacienteService.class);

    public PacienteEntity insert(PacienteEntity pacienteEntity) {

        logger.info(String.format("Inserido com sucesso"));

        return pacienteRepository.save(pacienteEntity);
    }

    public List<PacienteEntity> selectAll() {
        return pacienteRepository.findAll();
    }

    public PacienteEntity update(Integer id, String email) {
        if(pacienteRepository.existsById(id)) {

            logger.info(String.format("O paciente com id %s foi editado.", id));

            Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(id);
            pacienteEntity.get().setEmail(email);

            return insert(pacienteEntity.get());
        }
        return null;
    }

    public String delete(Integer id) {

        if(pacienteRepository.existsById(id)) {

            logger.info(String.format("Paciente com id: %s, foi deletado com sucesso", id));

            pacienteRepository.deleteById(id);

            return String.format("Paciente com id: %s, foi deletado com sucesso", id);
        }
        return null;
    }
}
