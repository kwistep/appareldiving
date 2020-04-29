package com.appareldiving.dataparsingadidasservice.repository;

import com.appareldiving.dataparsingadidasservice.dto.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Integer> {

}
