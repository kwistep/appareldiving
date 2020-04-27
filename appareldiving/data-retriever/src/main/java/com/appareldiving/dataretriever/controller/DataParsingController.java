package com.appareldiving.dataretriever.controller;

import com.appareldiving.dataretriever.exception.ListNullException;
import com.appareldiving.dataretriever.exception.UnsupportedOfferNumberException;
import com.appareldiving.dataretriever.response.ResponseModel;
import com.appareldiving.dataretriever.exception.UnsupportedParserException;
import com.appareldiving.dataretriever.service.IResponseService;
import com.appareldiving.dataretriever.service.IValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataParsingController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IResponseService responseService;

    @Autowired
    private IValidationService validationService;

    @GetMapping("/collect/{parser}/{quantity}")
    public ResponseEntity<?> collectLinks(@PathVariable String parser, @PathVariable int quantity) {


        try {
            validationService.validate(parser, quantity);
        } catch (UnsupportedParserException | UnsupportedOfferNumberException unsupportedParserException) {
            if( unsupportedParserException instanceof UnsupportedParserException)
            {
                return new ResponseEntity<>(new UnsupportedParserException(String.valueOf(parser)), HttpStatus.BAD_REQUEST);
            }
            else
            {
                return new ResponseEntity<>(new UnsupportedOfferNumberException(String.valueOf(quantity)), HttpStatus.BAD_REQUEST);
            }
        }


        List<String> links = responseService.getResponse(parser, quantity);

        ResponseModel response = new ResponseModel(quantity, links.size(), links);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/retrieve")
    public ResponseEntity<?> retrieveStoredLinks()
    {
        try {
            return new ResponseEntity<>(responseService.getStoredLinks(), HttpStatus.ACCEPTED);
        } catch (ListNullException e) {
            return new ResponseEntity<>(new ListNullException(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    // TODO add remove feature
    @DeleteMapping("/remove")
    public ResponseEntity<?> removeStoredLinks()
    {
        try {
            boolean removed = responseService.removeStoredLinks();
            if(removed)
                return new ResponseEntity<>(Boolean.TRUE, HttpStatus.ACCEPTED);
            else
                return new ResponseEntity<>(Boolean.FALSE, HttpStatus.BAD_REQUEST);

        } catch (ListNullException e) {
            return new ResponseEntity<>(new ListNullException(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    //TODO add hystrix

    public ResponseEntity<?> defaultData(){
        return new ResponseEntity<>(new ArrayList<>(0), HttpStatus.REQUEST_TIMEOUT);
    }

}
