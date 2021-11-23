package com.dh._26_injecao_independencias_mesa_trabalho.service;

import java.util.Map;

public interface IService <T, U> {
    Map<Integer, T> criar(U dao);
    Map<Integer, T> editar(U dao);
    Map<Integer, T> buscarTodos();
    Map<Integer, T> buscar(Integer id);
    String deletar(Integer id);
}
