package com.appareldiving.databaseservice.service;

import com.appareldiving.databaseservice.entity.Offer;
import com.appareldiving.databaseservice.entity.OfferDto;
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

        List<Offer> allOfferEntities = new ArrayList<>();
        allSaved.forEach(allOfferEntities::add);
        return allOfferEntities;
    }

    public List<OfferDto> getAllOffers()
    {
        Iterable<Offer> allRetrieved = offerRepository.findAll();

        List<Offer> offerEntities = new ArrayList<>();
        allRetrieved.forEach(offerEntities::add);

        return entityToDto(offerEntities);
    }



    private List<OfferDto> entityToDto(List<Offer> offerEntities)
    {
        List<OfferDto> offerDtos = new ArrayList<>();

        for (Offer offer : offerEntities)
        {
            OfferDto offerDto = new OfferDto();
            offerDto.setArticleId(offer.getArticleId());
            offerDto.setColor(offer.getColor());
            offerDto.setOfferId(offer.getOfferId());
            offerDto.setOrderable(offer.getOrderable());
            offerDto.setPrice(offer.getPrice());
            offerDto.setSalesPrice(offer.getSalesPrice());
            offerDto.setProductUrl(offer.getProductUrl());
            offerDto.setProductImages(offer.getProductImages());
            offerDtos.add(offerDto);
        }

        return offerDtos;
    }

}
