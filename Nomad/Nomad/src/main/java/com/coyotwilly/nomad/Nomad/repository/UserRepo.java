package com.coyotwilly.nomad.Nomad.repository;

import com.coyotwilly.nomad.Nomad.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByLastname(String name);
    User findByPinNumber(int pin);
    User findByDocumentNo(String document);
    User findByPassportNo(String passport);
}
