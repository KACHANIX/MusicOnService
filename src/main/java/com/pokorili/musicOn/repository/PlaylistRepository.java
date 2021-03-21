package com.pokorili.musicOn.repository;

import com.pokorili.musicOn.entity.Playlist;
import com.pokorili.musicOn.entity.Visitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
    Iterable<Playlist> findAllByTitleIgnoreCase(String title);
    Iterable<Playlist> findAllByVisitor(Visitor visitor);
    Iterable<Playlist> findAllByVisitorAndTitleIgnoreCase(Visitor visitor, String title);
}
