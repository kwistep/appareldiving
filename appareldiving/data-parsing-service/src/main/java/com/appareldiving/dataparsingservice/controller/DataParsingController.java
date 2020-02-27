package com.appareldiving.dataparsingservice.controller;

import com.appareldiving.dataparsingservice.controller.feign.ConsolidationProxy;
import com.appareldiving.dataparsingservice.dto.Product;
import com.appareldiving.dataparsingservice.dto.RequestData;
import com.appareldiving.dataparsingservice.service.IDataConverter;
import com.appareldiving.dataparsingservice.service.IRequestPerformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/request")
    public void processData(@RequestBody RequestData requestData){
        int requestId = requestData.getRequestId();
        String response = requestPerformer.getResponse(requestData.getLink());
        Product productData = dataConverter.getProductData(response);
        logger.info(productData.toString());
        proxy.saveProduct(productData);
    }


}
