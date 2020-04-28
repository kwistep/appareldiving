package com.appareldiving.dataparsingadidasservice.service;

import com.appareldiving.dataparsingadidasservice.dto.Offer;

import java.util.List;

public interface IRedisService {

    public boolean saveOffer(Offer offer);

    public List<Offer> retrieveAll();

}
