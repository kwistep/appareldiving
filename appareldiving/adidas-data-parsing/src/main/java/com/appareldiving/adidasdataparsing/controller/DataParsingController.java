package com.appareldiving.adidasdataparsing.controller;

import com.appareldiving.adidasdataparsing.controller.feign.DataScrappingControllerProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataParsingController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private int quantity;

    @Autowired
    private DataScrappingControllerProxy proxy;

    @GetMapping("/collect/adidas/{quantity}")
    public List<String> parseData(@PathVariable int quantity)
    {
        logger.info("That's me here!");

        List<String> strings = proxy.collectAndHandOnProductLinks(quantity);
        return strings;
    }

}
