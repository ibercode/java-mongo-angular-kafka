package com.ibercode.publisher.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ibercode.publisher.model.User;
import com.ibercode.publisher.service.UserProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserProducer userProducer;

    public UserController(UserProducer userProducer) {
        this.userProducer = userProducer;
    }

    @PostMapping(path = "/user")
    public String createUser(@RequestBody User user) throws JsonProcessingException {

        userProducer.sendMessage(user);

        return "User created successfully";
    }
}