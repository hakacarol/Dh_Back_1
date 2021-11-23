package com.dh._integradora.controller;

import com.dh._integradora.persitence.entities.ProdutoEntity;
import com.dh._integradora.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> getTodos() {
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> postProduto(@RequestBody ProdutoEntity produtoEntity) {
        return ResponseEntity.ok(produtoService.salvar(produtoEntity));
    }

    @PutMapping("{id}/{quantidade}")
    public ResponseEntity<ProdutoEntity> putProduto(@PathVariable Integer id, @PathVariable Integer quantidade) {
        return ResponseEntity.ok(produtoService.subtrair(id, quantidade));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable Integer id) {
        produtoService.deletar(id);
        return ResponseEntity.ok("Produto deletado com sucesso");
    }
}
