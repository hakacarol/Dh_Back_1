package com.dh._26_injecao_independencias_mesa_trabalho.service;

import com.dh._26_injecao_independencias_mesa_trabalho.dao.ConsultaDAO;
import com.dh._26_injecao_independencias_mesa_trabalho.model.Consulta;
import com.dh._26_injecao_independencias_mesa_trabalho.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConsultaService implements IService<Consulta, ConsultaDAO> {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public Map<Integer, Consulta> buscarTodos() {
        return consultaRepository.buscarTodos();
    }
    @Override
    public Map<Integer, Consulta> buscar(Integer id) {
        return consultaRepository.buscar(id);
    }
    @Override
    public String deletar(Integer id) {
        consultaRepository.deletar(id);
        return "Deletado com sucesso";
    }
    @Override
    public Map<Integer, Consulta> criar(ConsultaDAO dao) {
        Consulta consulta = new Consulta(dao.getPaciente(), dao.getDentista(), dao.getDataDaConsulta());
        return consultaRepository.criar(consulta);
    }

    @Override
    public Map<Integer, Consulta> editar(ConsultaDAO dao) {
        Consulta consulta = new Consulta(dao.getPaciente(), dao.getDentista(), dao.getDataDaConsulta());
        return consultaRepository.editar(consulta, dao.getId());
    }

}
