package com.coyotwilly.nomad.Nomad.service.Implementation;

import com.coyotwilly.nomad.Nomad.model.FutureTrips;
import com.coyotwilly.nomad.Nomad.model.User;
import com.coyotwilly.nomad.Nomad.repository.ImageRepo;
import com.coyotwilly.nomad.Nomad.repository.UserRepo;
import com.coyotwilly.nomad.Nomad.service.UserService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ImageRepo imageRepo;

    @Override
    public Boolean canLogIn(User credentials) {
        return Objects.equals(credentials.getPassword(), userRepo.findByEmailAddress(credentials.getEmailAddress()).getPassword());
    }

    @Override
    public Long lastUser(User user) {
        return userRepo.findByEmailAddress(user.getEmailAddress()).getId();
    }

    @Override
    public User saveUser(User user) {
        if ((user.getPassportNo().isEmpty()) || (user.getPin() == 0) || (user.getDocumentNo().isEmpty())){
            System.err.println("saveUser fail due empty of required fields.");
            return null;
        }
        return userRepo.save(user);
    }

    @Override
    public Optional<List<FutureTrips>> addTrip(Long id, FutureTrips futureTrips) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            // New trip object
            futureTrips.setImgBackground(imageRepo.findByUserId(id));

            // Current trips connected with given userId
            List<FutureTrips> trips = user.get().getFutureTrips();
            trips.add(futureTrips);

            // saving value to repository
            user.get().setFutureTrips(trips);
            userRepo.save(user.get());
            return Optional.of(user.get().getFutureTrips());
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> resetUserPassword(User user) {
        User savedUser = userRepo.findByEmailAddress(user.getEmailAddress());
        if (savedUser != null){
            savedUser.setPassword(user.getPassword());
            userRepo.save(savedUser);
            return Optional.of(savedUser);
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteUser(Long id) {
        if (userRepo.findById(id).isPresent()){
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> getUser(Long id){
        return userRepo.findById(id);
    }
    @Override
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Iterable<FutureTrips> getAllFutureTrips(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user.<Iterable<FutureTrips>>map(User::getFutureTrips).orElse(null);
    }
}
