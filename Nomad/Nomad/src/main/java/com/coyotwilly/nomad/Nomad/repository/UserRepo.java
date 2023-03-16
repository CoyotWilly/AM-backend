package com.coyotwilly.nomad.Nomad.repository;

import com.coyotwilly.nomad.Nomad.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findByLastName(String name);
    User findByPin(int pin);
    User findByDocumentNo(String document);
    User findByPassportNo(String passport);
}
