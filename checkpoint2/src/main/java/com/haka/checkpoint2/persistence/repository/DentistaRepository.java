package com.haka.checkpoint2.persistence.repository;

import com.haka.checkpoint2.persistence.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends JpaRepository <DentistaEntity, Integer> {
}
