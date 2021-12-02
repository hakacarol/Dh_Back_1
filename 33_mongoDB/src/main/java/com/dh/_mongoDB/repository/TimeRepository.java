package com.dh._mongoDB.repository;

import com.dh._mongoDB.model.Time;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends MongoRepository<Time, String> {
}
