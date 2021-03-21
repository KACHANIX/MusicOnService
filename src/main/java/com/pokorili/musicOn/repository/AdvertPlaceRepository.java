package com.pokorili.musicOn.repository;

import com.pokorili.musicOn.entity.AdvertPlace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertPlaceRepository extends CrudRepository<AdvertPlace, Long> {

    Iterable<AdvertPlace> findByIsFreeIs(Boolean isFree);
}
