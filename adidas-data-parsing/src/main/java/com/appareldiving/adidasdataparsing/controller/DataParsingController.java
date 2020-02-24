package com.appareldiving.adidasdataparsing.controller;

import com.appareldiving.adidasdataparsing.feign.DataScrappingControllerProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataParsingController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private DataScrappingControllerProxy proxy;

    @GetMapping("/collect/adidas")
    public List<String> parseData()
    {
        logger.info("That's me here!");

        List<String> strings = proxy.collectAndHandOnProductLinks();
        return strings;
    }

}
