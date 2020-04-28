package com.appareldiving.databaseservice.service;

import com.appareldiving.databaseservice.entity.Offer;
import com.appareldiving.databaseservice.entity.OfferDto;

import java.util.List;

public interface IOfferService {

    List<Offer> saveAllOffers(List<Offer> offers);

    List<OfferDto> getAllOffers();

}
