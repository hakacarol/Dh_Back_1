package com.haka.exercicio_aula.service;

import com.haka.exercicio_aula.domain.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorServer implements  IProfessor {

    @Override
    public List<Professor> listarProfessores() {
        List<Professor> lista = new ArrayList<>();

        lista.add(new Professor("Meg", 32, "Matematica"));
        lista.add(new Professor("Amora", 25, "História"));
        lista.add(new Professor("Hinata", 29, "Fisica"));

        return lista;
    }
}
