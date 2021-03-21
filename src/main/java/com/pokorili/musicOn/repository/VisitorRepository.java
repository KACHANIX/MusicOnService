package com.pokorili.musicOn.repository;

import com.pokorili.musicOn.entity.Visitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitorRepository extends CrudRepository<Visitor, Long> {

    Optional<Visitor> findByNickname(String nickname);
    Optional<Visitor> findByEmail(String email);

}
