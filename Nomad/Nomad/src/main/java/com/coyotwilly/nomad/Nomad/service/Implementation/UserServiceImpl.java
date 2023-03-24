package com.coyotwilly.nomad.Nomad.service.Implementation;

import com.coyotwilly.nomad.Nomad.model.User;
import com.coyotwilly.nomad.Nomad.repository.UserRepo;
import com.coyotwilly.nomad.Nomad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

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
    public Optional<User> getUser(Long id){
        return userRepo.findById(id);
    }
    @Override
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }
}
