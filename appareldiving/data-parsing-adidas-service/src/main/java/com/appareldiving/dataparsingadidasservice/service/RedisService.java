package com.appareldiving.dataparsingadidasservice.service;

import com.appareldiving.dataparsingadidasservice.dto.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RedisService implements IRedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private OfferRepository offerRepository;

    public boolean saveOffer(Offer offer)
    {
        Object saved = offerRepository.save(offer);
        //TODO exception
        return true;
    }


    public List<Offer> retrieveAll()
    {
        Iterable<Offer> all = offerRepository.findAll();
        List<Offer> offers = new ArrayList<>();
        all.forEach(offers::add);
        return offers;
    }

}



