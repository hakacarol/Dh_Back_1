package com.dh._26_injecao_independencias_mesa_trabalho.service;

import com.dh._26_injecao_independencias_mesa_trabalho.dao.DentistaDAO;
import com.dh._26_injecao_independencias_mesa_trabalho.model.Dentista;
import com.dh._26_injecao_independencias_mesa_trabalho.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DentistaService implements IService <Dentista, DentistaDAO> {

    @Autowired
    private DentistaRepository dentistaRepository;

    @Override
    public Map<Integer, Dentista> buscarTodos() {
        return dentistaRepository.buscarTodos();
    }

    @Override
    public Map<Integer, Dentista> buscar(Integer id) {
        return dentistaRepository.buscar(id);
    }

    @Override
    public String deletar(Integer id) {
        dentistaRepository.deletar(id);
        return "Deletado com sucesso";
    }

    @Override
    public Map<Integer, Dentista> criar(DentistaDAO dao) {
        Dentista dentista = new Dentista(dao.getNome(), dao.getEmail(), dao.getCredencial());
        return dentistaRepository.criar(dentista);
    }

    @Override
    public Map<Integer, Dentista> editar(DentistaDAO dao) {
        Dentista dentista = new Dentista(dao.getNome(), dao.getEmail(), dao.getCredencial());
        return dentistaRepository.editar(dentista, dao.getId());
    }
}
