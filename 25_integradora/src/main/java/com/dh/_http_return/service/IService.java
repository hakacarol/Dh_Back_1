package com.dh._http_return.service;

import java.util.Map;

public interface IService <T, U> {
    Map<Integer, T> buscar ();
    void deletar(Integer id);
    T criar(U dao);
    T editar(U dao);
}
