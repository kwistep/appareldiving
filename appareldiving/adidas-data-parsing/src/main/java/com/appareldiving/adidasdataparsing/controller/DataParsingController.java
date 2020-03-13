package com.appareldiving.adidasdataparsing.controller;

import com.appareldiving.adidasdataparsing.controller.feign.DataScrappingControllerProxy;
import com.appareldiving.adidasdataparsing.parser.ParserEnum;
import com.appareldiving.adidasdataparsing.response.UnsupportedNumberOfOffers;
import com.appareldiving.adidasdataparsing.response.ResponseModel;
import com.appareldiving.adidasdataparsing.response.UnsupportedParser;
import com.appareldiving.adidasdataparsing.service.IResponseService;
import com.appareldiving.adidasdataparsing.util.ParserUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DataParsingController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IResponseService responseService;

    @GetMapping("/collect/{parser}/{quantity}")
    @HystrixCommand(defaultFallback = "defaultData")
    public ResponseEntity<?> parseData(@PathVariable String parser, @PathVariable int quantity) {

        if( !ParserUtil.containsParser(parser) )
        {
            logger.warn("Parser [" + parser + "] is unsupported.");
            return new ResponseEntity<>(new UnsupportedParser(String.valueOf(parser)), HttpStatus.BAD_REQUEST);
        }

        if( quantity <= 0 || quantity > 1000 )
        {
            logger.warn("Quantity [" + quantity + "] is unsupported.");
            return new ResponseEntity<>(new UnsupportedNumberOfOffers(String.valueOf(quantity)), HttpStatus.BAD_REQUEST);
        }

        List<String> links = responseService.getResponse(parser, quantity);

        ResponseModel response = new ResponseModel(quantity, links.size(), links);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> defaultData(){
        return new ResponseEntity<>(new ArrayList<>(0), HttpStatus.REQUEST_TIMEOUT);
    }

}
