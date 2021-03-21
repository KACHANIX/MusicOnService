package com.pokorili.musicOn.repository;

import com.pokorili.musicOn.entity.History;
import com.pokorili.musicOn.entity.Visitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends CrudRepository<History,Long> {
    Iterable<History> findAllByVisitor(Visitor visitor);
}
