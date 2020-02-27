package com.appareldiving.dataconsolidationservice.controller;

import com.appareldiving.dataconsolidationservice.entity.Product;
import com.appareldiving.dataconsolidationservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsolidationController {

    @Autowired
    private IProductService productService;


    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product)
    {
        return productService.saveProduct(product);
    }

    @GetMapping("/get/all")
    public List<Product> getAll()
    {
        return productService.getAll();
    }

}
