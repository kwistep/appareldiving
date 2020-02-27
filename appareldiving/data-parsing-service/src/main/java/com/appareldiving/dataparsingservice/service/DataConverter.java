package com.appareldiving.dataparsingservice.service;

import com.appareldiving.dataparsingservice.dto.Product;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DataConverter implements IDataConverter{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Product getProductData(String response) {

        DocumentContext json = JsonPath.parse(response);

        Product product = new Product();

        logger.info(response);
        logger.info(json.toString());


        String productId = json.read("$.id");
        BigDecimal price = json.read("$.price", BigDecimal.class);
        BigDecimal salesPrice = json.read("$.salePrice", BigDecimal.class);
        List<String> productImages = json.read("$..src");
        String productUrl = "https://adidas.ca/" + json.read("$.link");
        String color = json.read("$.color");
        Boolean orderable = json.read("$.orderable");

        product.setProductId(productId);
        product.setPrice(price);
        product.setSalesPrice(salesPrice);
        product.setProductImages(productImages);
        product.setProductUrl(productUrl);
        product.setColor(color);
        product.setOrderable(orderable);

        return product;
    }
}
