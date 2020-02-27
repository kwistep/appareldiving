package com.appareldiving.adidasdatascraping.controller;

import com.appareldiving.adidasdatascraping.controller.feign.DataParsingServerProxy;
import com.appareldiving.adidasdatascraping.dto.RequestData;
import com.appareldiving.adidasdatascraping.service.ILinkCollector;
import com.appareldiving.adidasdatascraping.util.exceptions.InputUrlIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class DataScrappingController {

    @Value("${source.navigation.link}")
    String navigationLink;

    @Autowired
    private ILinkCollector linkCollector;

    @Autowired
    private DataParsingServerProxy proxy;

    @GetMapping(path = "/adidas")
    public List<String> collectAndHandOnProductLinks() throws IOException, InputUrlIsNull {

        List<String> links = linkCollector.collectProductLinks(navigationLink);

        String productLink = links.get(0);

        RequestData requestData = new RequestData();
        requestData.setRequestId(1);
        requestData.setLink(productLink);

        proxy.getData(requestData);

        return links;
    }


}
