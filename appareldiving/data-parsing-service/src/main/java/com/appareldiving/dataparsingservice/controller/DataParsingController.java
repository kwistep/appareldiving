package com.appareldiving.dataparsingservice.controller;

import com.appareldiving.dataparsingservice.controller.feign.ConsolidationProxy;
import com.appareldiving.dataparsingservice.dto.Offer;
import com.appareldiving.dataparsingservice.dto.RequestData;
import com.appareldiving.dataparsingservice.service.IDataConverter;
import com.appareldiving.dataparsingservice.service.IRequestPerformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataParsingController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IRequestPerformer requestPerformer;

    @Autowired
    private IDataConverter dataConverter;

    @Autowired
    private ConsolidationProxy proxy;

    @PostMapping("/request/{quantity}")
    public String processData( @RequestBody RequestData requestData, @PathVariable int quantity){
        int requestId = requestData.getRequestId();
        String response = requestPerformer.getResponse(requestData.getLink());
        Offer offerData = dataConverter.getOfferData(response);
        logger.info(offerData.toString());
        proxy.saveProduct(offerData, quantity);
        logger.info("Product [" + offerData.getOfferId() + " - " + offerData.getProductUrl() + "] was sent to consolidation center.");
        return "{\"response\":\"Yes\"}";
    }


}
