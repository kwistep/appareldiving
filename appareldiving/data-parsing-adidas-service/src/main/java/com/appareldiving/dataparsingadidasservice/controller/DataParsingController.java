package com.appareldiving.dataparsingadidasservice.controller;

import com.appareldiving.dataparsingadidasservice.controller.feign.DatabaseServiceProxy;
import com.appareldiving.dataparsingadidasservice.dto.Offer;
import com.appareldiving.dataparsingadidasservice.dto.RequestData;
import com.appareldiving.dataparsingadidasservice.service.IDataConverter;
import com.appareldiving.dataparsingadidasservice.service.IRedisService;
import com.appareldiving.dataparsingadidasservice.service.IRequestPerformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DataParsingController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IRequestPerformer requestPerformer;

    @Autowired
    private IDataConverter dataConverter;

    @Autowired
    private IRedisService redisService;

    @Autowired
    private DatabaseServiceProxy proxy;

    @PostMapping("/process")
    public boolean processData( @RequestBody RequestData requestData){
        String response = requestPerformer.getResponse(requestData.getLink());
        //TODO check exception
        Offer offerData = dataConverter.getOfferData(response);
        logger.info(offerData.toString());
        redisService.saveOffer(offerData);
//        proxy.saveProduct(offerData, quantity);
//        logger.info("Product [" + offerData.getOfferId() + " - " + offerData.getProductUrl() + "] was sent to consolidation center.");
        return Boolean.TRUE;
    }

    @PostMapping("/save")
    public boolean sendToDatabase()
    {
        List<Offer> offers = redisService.retrieveAll();
        proxy.saveData(offers);
        //TODO exception

        return true;

    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<Offer>> retrieveExtractedData()
    {
        return new ResponseEntity<>(redisService.retrieveAll(), HttpStatus.ACCEPTED);
    }


}