package com.coyotwilly.nomad.Nomad.service;

import com.coyotwilly.nomad.Nomad.model.FutureTrips;
import com.coyotwilly.nomad.Nomad.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<FutureTrips> addTrip(Long id, FutureTrips futureTrips);
    Optional<User> getUser(Long id);
    Iterable<User> getAllUsers();
    Iterable<FutureTrips> getAllFutureTrips(Long id);
    Boolean canLogIn(User credentials);
    Long lastUser(User user);
    Optional<User> resetUserPassword(User user);
    Boolean deleteUser(Long id);
}
