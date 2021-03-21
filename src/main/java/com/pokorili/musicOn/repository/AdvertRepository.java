package com.pokorili.musicOn.repository;

import com.pokorili.musicOn.entity.Advert;
import com.pokorili.musicOn.entity.AdvertPlace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdvertRepository extends CrudRepository<Advert, Long> {
    Iterable<Advert> findAllByAdvertPlaceNotNull();

    Optional<Advert> findByAdvertPlace(AdvertPlace place);

    Iterable<Advert> findAllByApprovalIsNullOrderByOfferDateDesc();

    Iterable<Advert> findAllByApproval(Boolean approval);
}
