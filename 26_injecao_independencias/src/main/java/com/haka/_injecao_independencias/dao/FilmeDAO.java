package com.haka._injecao_independencias.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmeDAO {

    private Integer id;
    private String nome;
    private String classificacao;
    private String genero;
    private String distribuidora;
}
