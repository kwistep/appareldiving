package com.appareldiving.dataconsolidationservice.controller;

import com.appareldiving.dataconsolidationservice.controller.feign.DataControllerProxy;
import com.appareldiving.dataconsolidationservice.entity.Offer;
import com.appareldiving.dataconsolidationservice.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsolidationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IProductService productService;

    @Autowired
    private DataControllerProxy proxy;


    @PostMapping("/save/{quantity}")
    public void saveProduct(@RequestBody Offer offer, @PathVariable int quantity)
    {

        logger.info("Offer [" + offer.getOfferId() + " - " + offer.getProductUrl() + "] was received.");
        productService.saveProduct(offer);
        logger.info("Offer [" + offer.getOfferId() + " - " + offer.getProductUrl() + "] was saved.");

        if( productService.isFinished(quantity) )
        {
            logger.info("FINISHED!");
            List<Offer> offers = productService.getAll();
            logger.info("Retrieved [" + offers.size() + "] offers.");
            proxy.saveData(offers);
        }

    }

    @GetMapping("/get/all")
    public List<Offer> getAll()
    {
        return productService.getAll();
    }

}
