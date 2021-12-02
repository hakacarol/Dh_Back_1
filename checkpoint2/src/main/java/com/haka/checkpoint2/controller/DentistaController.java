package com.haka.checkpoint2.controller;

import com.haka.checkpoint2.persistence.entity.DentistaEntity;
import com.haka.checkpoint2.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dentista")
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;

    @PostMapping
    public ResponseEntity<DentistaEntity> postDentista(@RequestBody DentistaEntity dentistaEntity) {
        return ResponseEntity.ok(dentistaService.insert(dentistaEntity));
    }

    @GetMapping
    public ResponseEntity<List<DentistaEntity>> getDentistas() {

        return ResponseEntity.ok(dentistaService.selectAll());
    }

    @PutMapping("{id}/{email}")
    public  ResponseEntity<DentistaEntity> putDentista (@PathVariable Integer id, @PathVariable String email) {
        DentistaEntity dentistaEntity = dentistaService.update(id, email);
        if(dentistaEntity == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(dentistaEntity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDentista(@PathVariable Integer id) {
        String resultado = dentistaService.delete(id);
        if(resultado == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(resultado);
    }
}