package com.dh._26_injecao_independencias_mesa_trabalho.controller;

import com.dh._26_injecao_independencias_mesa_trabalho.dao.ConsultaDAO;
import com.dh._26_injecao_independencias_mesa_trabalho.model.Consulta;
import com.dh._26_injecao_independencias_mesa_trabalho.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/consulta")
public class ConsultaController implements IController<Consulta, ConsultaDAO>{

    @Autowired
    private ConsultaService service;

    @Override
    public ResponseEntity<Map<Integer, Consulta>> getMethod() {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(0));
    }

    @Override
    public ResponseEntity<String> deleteMethod(@PathVariable Integer id) {
        service.deletar(id);

        return ResponseEntity.ok("Deletado com sucesso");
    }

    @Override
    public ResponseEntity<Consulta> postMethod(@RequestBody ConsultaDAO dao) {
        Consulta consulta = service.criar(dao);

        if (consulta == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(consulta);
    }

    @Override
    public ResponseEntity<Consulta> putMethod(@RequestBody ConsultaDAO dao) {
        return ResponseEntity.status(200).body(service.editar(dao));
    }
}
