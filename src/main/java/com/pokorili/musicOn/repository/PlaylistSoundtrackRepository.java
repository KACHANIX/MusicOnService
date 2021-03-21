package com.pokorili.musicOn.repository;

import com.pokorili.musicOn.entity.Playlist;
import com.pokorili.musicOn.entity.PlaylistSoundtrack;
import com.pokorili.musicOn.entity.Soundtrack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaylistSoundtrackRepository extends CrudRepository<PlaylistSoundtrack, Long> {
    Iterable<PlaylistSoundtrack> findAllByPlaylistId(Long id);
    Optional<PlaylistSoundtrack> findByPlaylistAndSoundtrack(Playlist playlist, Soundtrack soundtrack);
}
