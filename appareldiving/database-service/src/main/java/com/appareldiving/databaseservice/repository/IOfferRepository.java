package com.appareldiving.databaseservice.repository;

import com.appareldiving.databaseservice.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOfferRepository extends JpaRepository<Offer, Integer> {



}
