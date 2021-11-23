package com.haka._integracao.service;

import com.haka._integracao.dao.DentistaDao;
import com.haka._integracao.domain.Dentista;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DentistaService {

    // faz parte da classe, utilizo o mesmo
    private static Map<Integer, Dentista> flyweight = new HashMap<>();

    public Dentista registrarDentista(DentistaDao dentistaDao) {

        Integer id = flyweight.size()+1;
        Dentista dentista = new Dentista(dentistaDao.getNome(), dentistaDao.getSobrenome(), dentistaDao.getMatricula());

        // hashmap utiliza-se o put
        flyweight.put(id, dentista);

        return flyweight.get(id);
    }


    public Dentista buscarDentista(Integer id) {
        return flyweight.get(id);
    }

    public Map<Integer, Dentista> listarDentista() {
        return flyweight;
    }

    public Dentista atualizarDentista(DentistaDao dentistaDao) {

        Dentista dentista = flyweight.get(dentistaDao.getId());

        dentista.setNome(dentistaDao.getNome());
        dentista.setSobrenome(dentistaDao.getSobrenome());

        return dentista;
    }

    public String deletarDentista(Integer id) {
        flyweight.remove(id);

        return String.format("Dentista com id %s deletado", id);
    }








}
