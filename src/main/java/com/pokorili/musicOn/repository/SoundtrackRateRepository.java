package com.pokorili.musicOn.repository;

import com.pokorili.musicOn.entity.Soundtrack;
import com.pokorili.musicOn.entity.SoundtrackRate;
import com.pokorili.musicOn.entity.Visitor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface SoundtrackRateRepository extends CrudRepository<SoundtrackRate, Long> {

    Iterable<SoundtrackRate> findAllBySoundtrack(Soundtrack soundtrack);

    Iterable<SoundtrackRate> findAllByVisitorAndRate(Visitor visitor, Integer rate);

    Optional<SoundtrackRate> findBySoundtrackAndVisitor(Soundtrack soundtrack, Visitor visitor);

    @Query(value = "select soundtrack_id from soundtrack_rate group by soundtrack_id having sum(rate) > 0 order by sum(rate) desc limit 10;", nativeQuery = true)
    Iterable<BigInteger> findTop10SongIds();

}
