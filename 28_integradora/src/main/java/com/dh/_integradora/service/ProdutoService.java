package com.dh._integradora.service;

import com.dh._integradora.persitence.entities.ProdutoEntity;
import com.dh._integradora.persitence.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired // instancias as coisas
    private ProdutoRepository produtoRepository;

    public List<ProdutoEntity> buscarTodos() {
        return produtoRepository.findAll();
    }

    public ProdutoEntity salvar(ProdutoEntity produtoEntity){
        return produtoRepository.save(produtoEntity);
    }

    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoEntity subtrair(Integer id, Integer quantidade) {
        ProdutoEntity produto = produtoRepository.findById(id).get();
        produto.setQuantidade(produto.getQuantidade()-quantidade);
        produtoRepository.save(produto);
        return produto;
    }
}
