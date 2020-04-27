package com.appareldiving.dataretriever.service;

import com.appareldiving.dataretriever.exception.UnsupportedOfferNumberException;
import com.appareldiving.dataretriever.exception.UnsupportedParserException;

public interface IValidationService {

    boolean validate(String parser, int quantity) throws UnsupportedParserException, UnsupportedOfferNumberException;

}
