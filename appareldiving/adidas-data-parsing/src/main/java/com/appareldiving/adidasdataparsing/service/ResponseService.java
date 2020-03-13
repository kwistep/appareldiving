package com.appareldiving.adidasdataparsing.service;

import com.appareldiving.adidasdataparsing.controller.feign.DataScrappingControllerProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService implements IResponseService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataScrappingControllerProxy proxy;

    public List<String> getResponse(String parser, int quantity)
    {
        logger.info("[" + quantity + "] number of links were required when.");

        List<String> links = proxy.collectAndHandOnProductLinks(parser, quantity);

        logger.info("[" + links.size() + "] number of links were collected when.");

        return links;
    }


}
