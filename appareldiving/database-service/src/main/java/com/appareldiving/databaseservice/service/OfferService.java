package com.appareldiving.databaseservice.service;

import com.appareldiving.databaseservice.entity.Offer;
import com.appareldiving.databaseservice.repository.IOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferService implements IOfferService{

    @Autowired
    private IOfferRepository offerRepository;


    public List<Offer> saveAllOffers(List<Offer> offers)
    {
        Iterable<Offer> allSaved = offerRepository.saveAll(offers);

        List<Offer> allOffers = new ArrayList<>();
        allSaved.forEach(allOffers::add);
        return allOffers;
    }

    public List<Offer> getAllOffers()
    {
        Iterable<Offer> allRetrieved = offerRepository.findAll();

        List<Offer> offers = new ArrayList<>();
        allRetrieved.forEach(offers::add);
        return offers;
    }


}
