package com.coyotwilly.nomad.Nomad.repository;

import com.coyotwilly.nomad.Nomad.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends CrudRepository<Image, Long> {
    Image findByUserId(Long userId);
}
