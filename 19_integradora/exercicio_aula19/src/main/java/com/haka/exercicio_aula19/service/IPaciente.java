package com.haka.exercicio_aula19.service;

import com.haka.exercicio_aula19.domain.Paciente;

import java.util.List;

public interface IPaciente {

    List<Paciente> listarPaciente();

    Paciente pacientePorEmail (String email);
}
