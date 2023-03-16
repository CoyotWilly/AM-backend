package com.coyotwilly.nomad.Nomad.service.Implementation;

import com.coyotwilly.nomad.Nomad.model.User;
import com.coyotwilly.nomad.Nomad.repository.UserRepo;
import com.coyotwilly.nomad.Nomad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        if ((user.getPassportNo().isEmpty()) || (user.getPin() == 0) || (user.getIdDocumentNo().isEmpty())){
            System.err.println("saveUser fail due empty of required fields.");
            return null;
        }
        return userRepo.save(user);
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
