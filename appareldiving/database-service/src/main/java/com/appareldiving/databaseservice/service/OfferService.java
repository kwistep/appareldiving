package com.appareldiving.databaseservice.service;

import com.appareldiving.databaseservice.entity.Offer;
import com.appareldiving.databaseservice.repository.IOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService implements IOfferService{

    @Autowired
    private IOfferRepository offerRepository;


    private List<Offer> saveAllOffers(List<Offer> offers)
    {
        return offerRepository.saveAll(offers);
    }

    private List<Offer> getAllOffers()
    {
        return offerRepository.findAll();
    }


}
