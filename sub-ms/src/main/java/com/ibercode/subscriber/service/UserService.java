package com.ibercode.subscriber.service;

import com.ibercode.subscriber.model.User;
import com.ibercode.subscriber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveObject(User object) {
        return repository.save(object);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }
}