package com.pokorili.musicOn.repository;

import com.pokorili.musicOn.entity.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface GenreRepository extends CrudRepository<Genre,Long> {
    Optional<Genre> findByTitle(String title);

    List<Genre> findByParentGenre(Genre genre);
}
