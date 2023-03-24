package com.coyotwilly.nomad.Nomad.controller;

import com.coyotwilly.nomad.Nomad.model.User;
import com.coyotwilly.nomad.Nomad.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
    @PostMapping("user/passwordReset")
    ResponseEntity<?> resetUserPassword(@RequestBody User user){
        logger.info("Password reset: " + user);
        Optional<User> userFromRepo = userService.resetUserPassword(user);
        return userFromRepo.map(response -> ResponseEntity.ok().body(userFromRepo)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/matchingUserId")
    Long getLastAddedUser(@RequestBody User loginParams) {
        return userService.lastUser(loginParams);
    }
    @PostMapping("/user/login")
    Boolean getUserLoginCredential(@RequestBody User loginParams) {
        logger.info("Verification request with credentials: " + loginParams);
        return userService.canLogIn(loginParams);
    }
    @PostMapping("/user/sign-up")
    ResponseEntity<User> addUser(@Valid @RequestBody User user) throws URISyntaxException {
        logger.info("Request to add new User: " + user);
        User res = userService.saveUser(user);
        return ResponseEntity.created(new URI("/api/user/" + res.getId())).body(res);
    }

}
