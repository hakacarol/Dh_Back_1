package com.dh._http_return.dao;

import com.dh._http_return.model.Dentista;
import com.dh._http_return.model.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ConsultaDAO {

    private Integer id;
    private Paciente paciente;
    private Dentista dentista;
    @JsonFormat(pattern = "yyy-MM-dd HH:mm")
    private Date dataDaConsulta;

}
