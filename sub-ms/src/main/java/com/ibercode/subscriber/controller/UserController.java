package com.ibercode.subscriber.controller;

import com.ibercode.subscriber.model.User;
import com.ibercode.subscriber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        ResponseEntity<List<User>> responseEntity = new ResponseEntity(service.getAllUsers(), HttpStatus.OK);
        return responseEntity;
    }
}
