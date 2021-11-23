package com.haka._integracao.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Dentista {

    private String nome;
    private String sobrenome;
    private String matricula;

    public Dentista(String nome, String sobrenome, String matricula) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
    }
}
