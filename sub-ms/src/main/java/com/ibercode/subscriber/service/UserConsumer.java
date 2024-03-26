package com.ibercode.subscriber.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibercode.subscriber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserConsumer {

    private final UserService userService;

    @Autowired
    public UserConsumer(UserService userService){
        this.userService = userService;
    }

    @KafkaListener(topics = "user-topic", groupId = "user-group")
    public void listen(String message) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        User user = objectMapper.readValue(message, User.class);
        System.out.println("USER>>>" + user);

        user.setId(UUID.randomUUID().toString());
        userService.saveObject(user);

        System.out.println("USER saved to mongodb>>>" );
    }
}
