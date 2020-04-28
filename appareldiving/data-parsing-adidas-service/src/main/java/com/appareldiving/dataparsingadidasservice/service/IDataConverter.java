package com.appareldiving.dataparsingadidasservice.service;

import com.appareldiving.dataparsingadidasservice.dto.Offer;

public interface IDataConverter {

    public Offer getOfferData(String response);

}
