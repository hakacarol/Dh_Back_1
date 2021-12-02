package com.haka._30_spring_data_hibernate.repository;

import com.haka._30_spring_data_hibernate.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
}
