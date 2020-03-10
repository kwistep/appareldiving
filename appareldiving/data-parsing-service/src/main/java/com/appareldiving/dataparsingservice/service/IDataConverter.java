package com.appareldiving.dataparsingservice.service;

import com.appareldiving.dataparsingservice.dto.Offer;

public interface IDataConverter {

    public Offer getOfferData(String response);

}
