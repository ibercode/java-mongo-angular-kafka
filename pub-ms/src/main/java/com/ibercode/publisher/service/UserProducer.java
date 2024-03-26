package com.ibercode.publisher.service;

import com.ibercode.publisher.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProducer {

    @Autowired KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        kafkaTemplate.send("user-topic", user.getId().toString(), user);
    }
}
