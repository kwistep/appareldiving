package com.appareldiving.dataconsolidationservice.service;

import com.appareldiving.dataconsolidationservice.entity.Offer;

import java.util.List;

public interface IProductService {

    Offer saveProduct(Offer offer);

    List<Offer> getAll();

    Offer findById(String id);

    boolean isFinished(int quantity);

}
