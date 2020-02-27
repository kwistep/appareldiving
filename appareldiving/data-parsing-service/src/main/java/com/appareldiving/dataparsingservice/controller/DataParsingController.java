package com.appareldiving.dataparsingservice.controller;

import com.appareldiving.dataparsingservice.dto.Product;
import com.appareldiving.dataparsingservice.dto.RequestData;
import com.appareldiving.dataparsingservice.service.IDataConverter;
import com.appareldiving.dataparsingservice.service.IRequestPerformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DataParsingController {

    @Autowired
    private IRequestPerformer requestPerformer;

    @Autowired
    private IDataConverter dataConverter;


    @PostMapping("/product_request")
    public Product getData(@RequestBody RequestData requestData) throws IOException {
        int requestId = requestData.getRequestId();
        String response = requestPerformer.getResponse(requestData.getLink());
        return dataConverter.getProductData(response);
    }


}
