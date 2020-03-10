package com.appareldiving.dataconsolidationservice.repository;

import com.appareldiving.dataconsolidationservice.entity.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<Offer, String> {

    Offer findByOfferId(String id);

}
