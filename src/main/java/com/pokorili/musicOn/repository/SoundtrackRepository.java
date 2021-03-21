package com.pokorili.musicOn.repository;

import com.pokorili.musicOn.entity.Genre;
import com.pokorili.musicOn.entity.Soundtrack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoundtrackRepository extends CrudRepository<Soundtrack,Long> {
    Iterable<Soundtrack> findAllByGenre(Genre genre);

    Iterable<Soundtrack> findByTitleIgnoreCase(String title);

    Iterable<Soundtrack> findByAuthorIgnoreCase(String author);

    Iterable<Soundtrack> findAllByVisitorId(Long id);

    Iterable<Soundtrack> findAllByVisitorIdAndTitleIgnoreCase(Long id, String title);
}
