package com.coyotwilly.nomad.Nomad.controller;

import com.coyotwilly.nomad.Nomad.model.User;
import com.coyotwilly.nomad.Nomad.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(User.class);
    @Autowired
    private UserService userService;

    public UserController(UserService userService){ this.userService = userService;}

    @GetMapping("/user/{id}")
    ResponseEntity<?> getUserDetails(@PathVariable Long id){
        Optional<User> user = userService.getUser(id);
        return user.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
