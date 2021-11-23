package com.dh._26_injecao_independencias_mesa_trabalho.repository;

import java.util.Map;

public interface IRepository <T> {
    Map<Integer, T> criar(T objeto);
    Map<Integer, T> editar (T objeto, Integer id);
    Map<Integer, T> buscarTodos ();
    Map<Integer, T> buscar (Integer id);
    void deletar (Integer id);
}
