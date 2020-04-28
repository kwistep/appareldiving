package com.appareldiving.dataparsingadidasservice.service;

import com.appareldiving.dataparsingadidasservice.dto.Offer;
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
    public Offer getOfferData(String response) {

        DocumentContext json = JsonPath.parse(response);

        Offer offer = new Offer();

        logger.info(response);
        logger.info(json.toString());


        String offerId = json.read("$.id");
        BigDecimal price = json.read("$.price", BigDecimal.class);
        BigDecimal salesPrice = json.read("$.salePrice", BigDecimal.class);
        List<String> productImages = json.read("$..src");
        String productUrl = "https://adidas.ca/" + json.read("$.link");
        String color = json.read("$.color");
        Boolean orderable = json.read("$.orderable");

        int articleId = (offerId + productUrl).hashCode();

        offer.setArticleId(articleId);
        offer.setOfferId(offerId);
        offer.setPrice(price);
        offer.setSalesPrice(salesPrice);
        offer.setProductImages(productImages);
        offer.setProductUrl(productUrl);
        offer.setColor(color);
        offer.setOrderable(orderable);

        return offer;
    }
}
