package com.coyotwilly.nomad.Nomad.service;

import com.coyotwilly.nomad.Nomad.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUser(Long id);
    Iterable<User> getAllUsers();
}
