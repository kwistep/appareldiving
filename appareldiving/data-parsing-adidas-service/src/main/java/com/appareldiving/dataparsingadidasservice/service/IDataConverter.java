package com.appareldiving.dataparsingadidasservice.service;

import com.appareldiving.dataparsingadidasservice.dto.Offer;
import com.appareldiving.dataparsingadidasservice.exception.EmptyResponseException;

public interface IDataConverter {

    public Offer getOfferData(String response) throws EmptyResponseException;

}
