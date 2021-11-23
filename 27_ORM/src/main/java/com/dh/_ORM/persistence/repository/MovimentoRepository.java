package com.dh._ORM.persistence.repository;

import com.dh._ORM.persistence.entities.MovimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoRepository extends JpaRepository <MovimentoEntity, Integer> {
}
