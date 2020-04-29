package com.appareldiving.databaseservice.service;

import com.appareldiving.databaseservice.entity.Offer;
import com.appareldiving.databaseservice.entity.OfferDto;
import com.appareldiving.databaseservice.repository.IOfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferService implements IOfferService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IOfferRepository offerRepository;


    public void saveAllOffers(List<Offer> offers) {
        Iterable<Offer> allSaved = offerRepository.saveAll(offers);
        List<Offer> saved = new ArrayList<>();
        allSaved.forEach(saved::add);
        logger.info("Offers saved [" + saved.size() + "].");
    }

    public List<OfferDto> getAllOffers() {
        Iterable<Offer> allRetrieved = offerRepository.findAll();

        List<Offer> offerEntities = new ArrayList<>();
        allRetrieved.forEach(offerEntities::add);

        logger.info("Offers retrieved from database [" + offerEntities.size() + "].");

        return entityToDto(offerEntities);
    }


    private List<OfferDto> entityToDto(List<Offer> offerEntities) {
        List<OfferDto> offerDtos = new ArrayList<>();

        for (Offer offer : offerEntities) {
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
