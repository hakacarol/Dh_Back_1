package com.dh._26_injecao_independencias_mesa_trabalho.service;

import com.dh._26_injecao_independencias_mesa_trabalho.dao.PacienteDAO;
import com.dh._26_injecao_independencias_mesa_trabalho.model.Paciente;
import com.dh._26_injecao_independencias_mesa_trabalho.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PacienteService implements IService <Paciente, PacienteDAO>  {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Map<Integer, Paciente> buscarTodos() {
        return pacienteRepository.buscarTodos();
    }

    @Override
    public Map<Integer, Paciente> buscar(Integer id) {
        return pacienteRepository.buscar(id);
    }

    @Override
    public String deletar(Integer id) {
        pacienteRepository.deletar(id);
        return "Deletado com sucesso";
    }

    @Override
    public Map<Integer, Paciente> criar(PacienteDAO dao) {
        Paciente paciente = new Paciente(dao.getNome(), dao.getSobrenome(), dao.getEmail());
        return pacienteRepository.criar(paciente);
    }

    @Override
    public Map<Integer, Paciente> editar(PacienteDAO dao) {
        Paciente paciente = new Paciente(dao.getNome(), dao.getSobrenome(), dao.getEmail());
        return pacienteRepository.editar(paciente, dao.getId());
    }
}
