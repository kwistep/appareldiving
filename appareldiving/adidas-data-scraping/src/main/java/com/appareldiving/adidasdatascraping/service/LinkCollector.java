package com.appareldiving.adidasdatascraping.service;

import com.appareldiving.adidasdatascraping.util.GetRequest;
import com.appareldiving.adidasdatascraping.util.RequestUtil;
import com.appareldiving.adidasdatascraping.util.exceptions.InputUrlIsNull;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LinkCollector implements ILinkCollector {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<String> collectProductLinks(String navigationLink, int quantity) throws IOException, InputUrlIsNull {
        String response = performRequest(navigationLink);
        List<String> productIds = extractProductIds(response, quantity);
        return buildProductLink(productIds);
    }


    private String performRequest(String navigationLink) throws IOException, InputUrlIsNull {
        GetRequest getRequest = RequestUtil.prepareGetRequest(navigationLink);
        logger.info("Request to [" + navigationLink + "] has been prepared.");
        RequestUtil.performRequest(getRequest);
        logger.info("Request to [" + navigationLink + "] has been performed.");
        return getRequest.getResponse();
    }

    private List<String> extractProductIds(String response, int quantity) {
        String[] productIdsArray = StringUtils.substringsBetween(response, "productId\\\":\\\"", "\\\",");

        List<String> productIds;

        if (productIdsArray.length > quantity) {
            productIds = Arrays.asList(productIdsArray).subList(0, quantity);
        } else {
            productIds = Arrays.asList(productIdsArray);
        }

        logger.info("Product id(s) gathered [" + productIds.size() + "].");

        return productIds;
    }

    private List<String> buildProductLink(List<String> productIds) {
        List<String> productLinks = new ArrayList<>();

        for (String productId : productIds) {
            productLinks.add("https://www.adidas.ca/api/search/product/" + productId + "?sitePath=en");
        }

        logger.info("Product links created [" + productLinks.size() + "].");

        return productLinks;
    }

}
