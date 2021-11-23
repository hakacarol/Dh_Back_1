package com.dh._26_injecao_independencias_mesa_trabalho.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDAO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
}
