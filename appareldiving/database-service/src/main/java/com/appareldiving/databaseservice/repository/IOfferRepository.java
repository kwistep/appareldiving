package com.appareldiving.databaseservice.repository;

import com.appareldiving.databaseservice.entity.Offer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOfferRepository extends ElasticsearchRepository<Offer, String> {



}
