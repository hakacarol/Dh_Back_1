package com.dh._26_injecao_independencias_mesa_trabalho.repository;

import com.dh._26_injecao_independencias_mesa_trabalho.model.Paciente;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PacienteRepository implements IRepository <Paciente> {
    public static Map<Integer, Paciente> mapPaciente = new HashMap<>();
    @Override
    public Map<Integer, Paciente> criar(Paciente objeto) {

        Integer id = mapPaciente.size() + 1;
        mapPaciente.put(id,objeto);

        Map<Integer, Paciente> mapCriar = new HashMap<>();
        mapCriar.put(id, mapPaciente.get(id));

        return mapCriar;
    }

    @Override
    public Map<Integer, Paciente>  editar(Paciente objeto, Integer id) {

        Paciente editarPaciente = mapPaciente.get(id);
        editarPaciente.setEmail(objeto.getEmail());

        Map<Integer, Paciente> mapEditar = new HashMap<>();
        mapEditar.put(id, editarPaciente);

        return mapEditar;
    }

    @Override
    public Map<Integer, Paciente> buscarTodos() {
        return mapPaciente;
    }

    @Override
    public Map<Integer, Paciente> buscar(Integer id) {

        Map<Integer, Paciente> mapBuscar = new HashMap<>();
        mapBuscar.put(id, mapPaciente.get(id));

        return mapBuscar;
    }

    @Override
    public void deletar(Integer id) {
        mapPaciente.remove(id);
    }



}
