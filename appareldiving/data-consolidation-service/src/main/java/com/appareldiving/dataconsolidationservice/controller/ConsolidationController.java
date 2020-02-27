package com.appareldiving.dataconsolidationservice.controller;

import com.appareldiving.dataconsolidationservice.entity.Product;
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


    @PostMapping("/save/{quantity}")
    public void saveProduct(@RequestBody Product product, @PathVariable int quantity)
    {

        logger.info("Product [" + product.getProductId() + " - " + product.getProductUrl() + "] was received.");
        productService.saveProduct(product);
        logger.info("Product [" + product.getProductId() + " - " + product.getProductUrl() + "] was saved.");

        if( productService.isFinished(quantity) )
        {
            //TODO Push DAta to ElasticSearch
            logger.info("FINISHED!");
        }

    }

    @GetMapping("/get/all")
    public List<Product> getAll()
    {
        return productService.getAll();
    }

}
