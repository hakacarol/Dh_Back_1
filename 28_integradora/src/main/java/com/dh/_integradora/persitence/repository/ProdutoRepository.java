package com.dh._integradora.persitence.repository;

import com.dh._integradora.persitence.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository <ProdutoEntity, Integer> {
}
