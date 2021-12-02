package com.dh._mongoDB.service;

import com.dh._mongoDB.model.Time;
import com.dh._mongoDB.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public Time createTime(Time time) {
        return repository.save(time);
    }
}