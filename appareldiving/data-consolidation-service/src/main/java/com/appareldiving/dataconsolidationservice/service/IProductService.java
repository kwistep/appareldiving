package com.appareldiving.dataconsolidationservice.service;

import com.appareldiving.dataconsolidationservice.entity.Product;

import java.util.List;

public interface IProductService {

    Product saveProduct(Product product);

    List<Product> getAll();


}
