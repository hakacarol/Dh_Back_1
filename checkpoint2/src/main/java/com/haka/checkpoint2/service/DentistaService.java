package com.haka.checkpoint2.service;

import com.haka.checkpoint2.persistence.entity.DentistaEntity;
import com.haka.checkpoint2.persistence.repository.DentistaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {

    @Autowired
    private DentistaRepository dentistaRepository;

    private static final Logger logger = Logger.getLogger(DentistaService.class);

    public DentistaEntity insert(DentistaEntity dentistaEntity) {

        logger.info(String.format("Dentista inserido com sucesso!"));

        return dentistaRepository.save(dentistaEntity);
    }

    public List<DentistaEntity> selectAll() {
        return dentistaRepository.findAll();
    }

    public DentistaEntity update(Integer id, String email) {

        if (dentistaRepository.existsById(id)) {

            logger.info(String.format("Dentista com id: %s, alterado com sucesso", id));

            Optional<DentistaEntity> dentistaEntity = dentistaRepository.findById(id);
            dentistaEntity.get().setEmail(email);

            return insert(dentistaEntity.get());
        }
        return null;
    }

    public String delete(Integer id) {

        if (dentistaRepository.existsById(id)) {

            logger.info(String.format("Paciente com id: %s, foi deletado com sucesso", id));

            dentistaRepository.deleteById(id);

            return String.format("Paciente com id: %s, foi deletado com sucesso", id);
        }
        return null;
    }
}
