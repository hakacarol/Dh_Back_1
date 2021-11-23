package com.haka.exercicio_aula19.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Paciente {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private Date dateCadastro;
    private Endereco endereco;

    public Paciente(Integer id, String nome, String sobrenome, String cpf, String email, Date dateCadastro, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.dateCadastro = dateCadastro;
        this.endereco = endereco;
    }
}
