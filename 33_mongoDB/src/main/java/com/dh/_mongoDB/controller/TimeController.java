package com.dh._mongoDB.controller;

import com.dh._mongoDB.model.Time;
import com.dh._mongoDB.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService service;

    @PostMapping
    public Time postTime(@RequestBody Time time) {
        return service.createTime(time);
    }
}
