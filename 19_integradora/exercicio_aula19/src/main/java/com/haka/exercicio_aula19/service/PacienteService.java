package com.haka.exercicio_aula19.service;

import com.haka.exercicio_aula19.domain.Endereco;
import com.haka.exercicio_aula19.domain.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PacienteService implements IPaciente{

    @Override
    public List<Paciente> listarPaciente() {
        List<Paciente> lista = new ArrayList<>();

        lista.add(new Paciente (1234,"Maria", "Silva", "123456789", "mariasilva@gmail.com",
                new Date(), new Endereco("rua das Gracas", "123", "Sao Paulo", "SP")));

        lista.add(new Paciente (1235,"Marcolerio", "Vidoti", "443456789", "marcolerio@gmail.com",
                new Date(), new Endereco("rua da Piedade", "424", "Cotia", "SP")));

        lista.add(new Paciente (1236,"Renan", "Mofo", "553456789", "rantos9@gmail.com",
                new Date(), new Endereco("rua da Salvacao", "555", "Embu das Artes", "SP")));

        return lista;
    }

    @Override
    public Paciente pacientePorEmail(String email) {
        return new Paciente(12345, "Paciente", "Por Email", "123456789", email, new Date(),
                new Endereco("Rua do Paciente", "777", "Carapicuiba", "SP"));
    }
}
