package com.coyotwilly.nomad.Nomad.service;

import com.coyotwilly.nomad.Nomad.model.ActiveTrips;
import com.coyotwilly.nomad.Nomad.model.FutureTrips;
import com.coyotwilly.nomad.Nomad.model.PastTrips;
import com.coyotwilly.nomad.Nomad.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<List<FutureTrips>> addTrip(Long id,Long imgId, FutureTrips futureTrips);
    ResponseEntity<String> moveToActive();
    Optional<User> getUser(Long id);
    Iterable<User> getAllUsers();
    Iterable<FutureTrips> getAllFutureTrips(Long id);
    Iterable<ActiveTrips> getAllActiveTrips(Long id);
    Iterable<PastTrips> getAllPastTrips(Long id);
    Boolean canLogIn(User credentials);
    Long lastUser(User user);
    Optional<User> resetUserPassword(User user);
    Boolean deleteUser(Long id);
}
