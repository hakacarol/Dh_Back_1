package com.dh._http_return.service;

import com.dh._http_return.dao.ConsultaDAO;
import com.dh._http_return.model.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConsultaService implements IService<Consulta, ConsultaDAO> {

    private static Map<Integer, Consulta> mapConsulta = new HashMap<>();

    @Autowired
    public PacienteService pacienteService;
    @Autowired
    public DentistaService dentistaService;

    @Override
    public Map<Integer, Consulta> buscar() {
        return mapConsulta;
    }

    @Override
    public void deletar(Integer id) {
        mapConsulta.remove(id);
    }

    @Override
    public Consulta criar(ConsultaDAO dao) {
//        if(!dentistaService.buscar().containsKey(dao.getDentista().getCredencial()) || !pacienteService.buscar().containsKey(dao.getPaciente().getEmail())) {
//            return null;
//        }

        Integer id = mapConsulta.size() + 1;

        mapConsulta.put(id, new Consulta(dao.getPaciente(), dao.getDentista(), dao.getDataDaConsulta()));

        return mapConsulta.get(id);
    }

    @Override
    public Consulta editar(ConsultaDAO dao) {
        Consulta consulta = mapConsulta.get(dao.getId());
        consulta.setDataDaConsulta(dao.getDataDaConsulta());

        return consulta;
    }
}
