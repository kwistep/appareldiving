package com.appareldiving.adidasdataparsing.service;

import com.appareldiving.adidasdataparsing.exception.UnsupportedOfferNumberException;
import com.appareldiving.adidasdataparsing.exception.UnsupportedParserException;

public interface IValidationService {

    boolean validate(String parser, int quantity) throws UnsupportedParserException, UnsupportedOfferNumberException;

}
