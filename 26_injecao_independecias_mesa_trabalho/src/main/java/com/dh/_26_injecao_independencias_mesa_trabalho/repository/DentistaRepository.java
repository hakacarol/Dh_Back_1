package com.dh._26_injecao_independencias_mesa_trabalho.repository;

import com.dh._26_injecao_independencias_mesa_trabalho.model.Dentista;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DentistaRepository implements IRepository <Dentista> {

    public static Map<Integer, Dentista> mapDentista = new HashMap<>();

    @Override
    public Map<Integer, Dentista> criar(Dentista objeto) {

        Integer id = mapDentista.size() + 1;
        mapDentista.put(id, objeto);

        Map<Integer, Dentista> mapCriar = new HashMap<>();
        mapCriar.put(id, mapDentista.get(id));

        return mapCriar;
    }

    @Override
    public Map<Integer, Dentista> editar(Dentista objeto, Integer id) {

        Dentista editarDentista = mapDentista.get(id);
        editarDentista.setEmail(objeto.getEmail());

        Map<Integer, Dentista> mapEditar = new HashMap<>();
        mapEditar.put(id, editarDentista);

        return mapEditar;
    }

    @Override
    public Map<Integer, Dentista> buscarTodos() {
        return mapDentista;
    }
    @Override
    public Map<Integer, Dentista> buscar(Integer id) {

        Map<Integer, Dentista> mapBuscar = new HashMap<>();
        mapBuscar.put(id, mapDentista.get(id));

        return mapBuscar;
    }

    @Override
    public void deletar(Integer id) {
        mapDentista.remove(id);
    }




}
