package com.dh._http_return.service;

import com.dh._http_return.dao.DentistaDAO;
import com.dh._http_return.model.Dentista;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DentistaService implements IService<Dentista, DentistaDAO> {

    private static Map<Integer, Dentista> mapDentista = new HashMap<>();

    @Override
    public Map<Integer, Dentista> buscar() {
        return mapDentista;
    }

    @Override
    public void deletar(Integer id) {
        mapDentista.remove(id);
    }

    @Override
    public Dentista criar(DentistaDAO dao) {

        Integer id = mapDentista.size() + 1;

        mapDentista.put(id, new Dentista(dao.getNome(), dao.getEmail(), dao.getCredencial()));

        return mapDentista.get(id);
    }

    @Override
    public Dentista editar(DentistaDAO dao) {
        Dentista dentista = mapDentista.get(dao.getId());
        dentista.setEmail(dao.getEmail());

        return dentista;
    }
}
