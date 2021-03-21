package com.pokorili.musicOn.repository;

import com.pokorili.musicOn.entity.Playlist;
import com.pokorili.musicOn.entity.PlaylistRate;
import com.pokorili.musicOn.entity.Visitor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface PlaylistRateRepository extends CrudRepository<PlaylistRate, Long> {
    Iterable<PlaylistRate> findAllByPlaylist(Playlist playlist);
    Iterable<PlaylistRate> findAllByVisitorAndRate(Visitor visitor, Integer rate);
    Optional<PlaylistRate> findByPlaylistAndVisitor(Playlist playlist, Visitor visitor);

    @Query(value = "select playlist_id from playlist_rate group by playlist_id having sum(rate) > 0 order by sum(rate) desc limit 10;", nativeQuery = true)
    Iterable<BigInteger> findTop10Playlists();
}
