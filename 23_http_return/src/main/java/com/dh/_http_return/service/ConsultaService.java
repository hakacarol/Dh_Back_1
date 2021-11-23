package com.dh._http_return.service;

import com.dh._http_return.dao.ConsultaDAO;
import com.dh._http_return.model.Consulta;
import com.dh._http_return.model.Dentista;
import com.dh._http_return.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConsultaService {

    private static Map<String, Dentista> mapDentista = new HashMap<>();
    private static Map<String, Paciente> mapPaciente = new HashMap<>();
    private static Map<Integer, Consulta> mapConsulta = new HashMap<>();

    public ConsultaService() {
        mapDentista.put("123456", new Dentista("Ana Beatriz", "anabeatriz@gmail.com", "123456"));
        mapDentista.put("123457", new Dentista("Jonas Silva", "jonassilva@gmail.com", "234567"));
        mapDentista.put("123458", new Dentista("Julio Alberto", "julioalberto@gmail.com", "345678"));

        mapPaciente.put("lucaspaglia@gmail.com", new Paciente("Lucas", "Paglia", "lucaspaglia@gmail.com"));
        mapPaciente.put("antoniosantos@gmail.com", new Paciente("Antonio", "Santos", "antoniosantos@gmail.com"));
        mapPaciente.put("samantarodrigues@gmail.com", new Paciente("Samanta", "Rodrigues", "samantarodrigues@gmail.com"));
    }

    public Map<Integer, Consulta> buscarConsultas() {
        return mapConsulta;
    }

    public void deletarConsulta(Integer id) {
        mapConsulta.remove(id);
    }

    public Consulta criarConsulta(ConsultaDAO dao) {
        if(!mapDentista.containsKey(dao.getDentista().getCredencial()) || !mapPaciente.containsKey(dao.getPaciente().getEmail())) {
            return null;
        }

        Integer id = mapConsulta.size() + 1;

        mapConsulta.put(id, new Consulta(dao.getPaciente(), dao.getDentista(), dao.getDataDaConsulta()));

        return mapConsulta.get(id);
    }

    public Consulta editarConsulta(ConsultaDAO dao) {
        Consulta consulta = mapConsulta.get(dao.getId());
        consulta.setDataDaConsulta(dao.getDataDaConsulta());

        return consulta;
    }
}
