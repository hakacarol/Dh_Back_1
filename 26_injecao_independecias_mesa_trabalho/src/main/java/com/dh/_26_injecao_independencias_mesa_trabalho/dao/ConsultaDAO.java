package com.dh._26_injecao_independencias_mesa_trabalho.dao;

import com.dh._26_injecao_independencias_mesa_trabalho.model.Dentista;
import com.dh._26_injecao_independencias_mesa_trabalho.model.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
// dao faz conexão com com bd
// mas aqui é uma adaptação
public class ConsultaDAO {

    private Integer id;
    private Paciente paciente;
    private Dentista dentista;
    @JsonFormat(pattern = "yyy-MM-dd HH:mm")
    private Date dataDaConsulta;
}
