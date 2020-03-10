package com.appareldiving.databaseservice.controller;

import com.appareldiving.databaseservice.entity.Offer;
import com.appareldiving.databaseservice.service.IOfferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IOfferService service;

    @PutMapping(path = "/save")
    public List<Offer> saveData(@RequestBody List<Offer> offers)
    {
        logger.info("Saving all offers...");
        //TODO finish it
        return service.saveAllOffers(offers);
    }

    @GetMapping(path = "/retrieve_all")
    public List<Offer> getAllData()
    {
        logger.info("Retrieving all offers...");
        return service.getAllOffers();
    }

}
