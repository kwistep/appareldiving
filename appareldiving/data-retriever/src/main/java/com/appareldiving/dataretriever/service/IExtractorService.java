package com.appareldiving.dataretriever.service;

import com.appareldiving.dataretriever.exception.ListNullException;

public interface IExtractorService {

    void sendData() throws ListNullException;

}
