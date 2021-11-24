package com.dh._ORM_mesa_trabalho.persistence.repository;

import com.dh._ORM_mesa_trabalho.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Integer> {

}
