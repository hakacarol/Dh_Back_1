package com.haka._revisao.service;

import com.haka._revisao.domain.Paciente;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class PacienteService {

    // criação da lista
    private static Map<Integer, Paciente> flyweight = new HashMap<>();

    private static String[] nomesVec = {"Lucas", "Ana", "Pedro", "Julia", "Roberto",
            "Larissa", "Antonio", "Pietra", "Rubens", "Giovana"};

    private static String[] sobrenomesVec = {"Silva", "Santos", "Gomes", "Paglia", "Grisa",
            "Andrade", "Quinteiros", "Tempesta", "Franco", "Andrade"};

    public Map<Integer, Paciente> buscarPacientes() {
        return flyweight;
    }

    //criação aleatória do paciente
    public Paciente criarPaciente() {
        Random random = new Random();
        Integer limiteRandom = 10;
        String nome = nomesVec[random.nextInt(limiteRandom)];
        String sobrenome = sobrenomesVec[random.nextInt(limiteRandom)];
        String email = nome.toLowerCase() + sobrenome.toLowerCase() + "@gmail.com";
        Integer id = flyweight.size() + 1;

        flyweight.put(id, new Paciente(nome, sobrenome, email, (random.nextInt(45 - 18 + 1) + 18)));

        return flyweight.get(id);
    }

    public void deletarPaciente(Integer id){
         flyweight.remove(id);
    }
}
