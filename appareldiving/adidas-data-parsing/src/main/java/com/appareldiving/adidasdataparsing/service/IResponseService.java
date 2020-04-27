package com.appareldiving.adidasdataparsing.service;

import com.appareldiving.adidasdataparsing.exception.ListNullException;

import java.util.List;

public interface IResponseService {

    List<String> getResponse(String parser, int quantity);

    List<? super String> getStoredLinks() throws ListNullException;

}
