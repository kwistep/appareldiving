package com.appareldiving.adidasdatascraping.controller;

import com.appareldiving.adidasdatascraping.controller.feign.DataParsingServerProxy;
import com.appareldiving.adidasdatascraping.dto.RequestData;
import com.appareldiving.adidasdatascraping.service.ILinkCollector;
import com.appareldiving.adidasdatascraping.util.exceptions.InputUrlIsNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class DataScrappingController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${source.navigation.link}")
    String navigationLink;

    @Autowired
    private ILinkCollector linkCollector;

    @Autowired
    private DataParsingServerProxy proxy;

    @GetMapping(path = "/adidas/{quantity}")
    public List<String> collectAndHandOnProductLinks(@PathVariable int quantity) throws IOException, InputUrlIsNull {

        List<String> links = linkCollector.collectProductLinks(navigationLink, quantity);

        logger.info("[" + links.size() + "] link were collected.");

        for (String productLink : links)
        {
            RequestData requestData = new RequestData();
            requestData.setRequestId(productLink.hashCode());
            requestData.setLink(productLink);

            proxy.getData(requestData, quantity);

            logger.info("Request to [" + productLink + "] was sent.");
        }

        return links;
    }


}
