package com.appareldiving.dataconsolidationservice.repository;

import com.appareldiving.dataconsolidationservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<Product, String> {
}
