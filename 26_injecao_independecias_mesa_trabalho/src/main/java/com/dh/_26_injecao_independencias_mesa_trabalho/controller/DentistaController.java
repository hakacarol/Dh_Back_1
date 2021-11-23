package com.dh._26_injecao_independencias_mesa_trabalho.controller;

import com.dh._26_injecao_independencias_mesa_trabalho.dao.DentistaDAO;
import com.dh._26_injecao_independencias_mesa_trabalho.model.Dentista;
import com.dh._26_injecao_independencias_mesa_trabalho.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dentista")
public class DentistaController implements IController<Dentista, DentistaDAO> {

    @Autowired
    private DentistaService dentistaService;
    @Override
    public ResponseEntity<Map<Integer, Dentista>> getMethod() {
        return ResponseEntity.status(200).body(dentistaService.buscar());
    }

    @Override
    public ResponseEntity<String> deleteMethod(Integer id) {
        return ResponseEntity.status(200).body("Deletado com sucesso!");
    }

    @Override
    public ResponseEntity<Dentista> postMethod(DentistaDAO dao) {
        Dentista dentista = dentistaService.criar(dao);

        if (dentista == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(dentista);
    }

    @Override
    public ResponseEntity<Dentista> putMethod(DentistaDAO dao) {
        return ResponseEntity.status(200).body(dentistaService.editar(dao));
    }
}
