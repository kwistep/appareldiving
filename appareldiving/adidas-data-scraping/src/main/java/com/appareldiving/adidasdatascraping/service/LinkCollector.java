package com.appareldiving.adidasdatascraping.service;

import com.appareldiving.adidasdatascraping.util.GetRequest;
import com.appareldiving.adidasdatascraping.util.RequestUtil;
import com.appareldiving.adidasdatascraping.util.exceptions.InputUrlIsNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LinkCollector implements ILinkCollector{


    @Override
    public List<String> collectProductLinks(String navigationLink, int quantity) throws IOException, InputUrlIsNull {
        String response = performRequest(navigationLink);
        List<String> productIds = extractProductIds(response, quantity);
        return buildProductLink(productIds);
    }


    private String performRequest(String navigationLink) throws IOException, InputUrlIsNull
    {
        GetRequest getRequest = RequestUtil.prepareGetRequest(navigationLink);
        RequestUtil.performRequest(getRequest);
        return getRequest.getResponse();
    }

    private List<String> extractProductIds(String response, int quantity)
    {
        String[] productIdsArray = StringUtils.substringsBetween(response, "productId\\\":\\\"", "\\\",");

        List<String> productIds;

        if( productIdsArray.length > quantity )
        {
            productIds  = Arrays.asList(productIdsArray).subList(0, quantity);
        }
        else
        {
            productIds = Arrays.asList(productIdsArray);
        }
        return productIds;
    }

    private List<String> buildProductLink(List<String> productIds)
    {
        List<String> productLinks = new ArrayList<>();

        for ( String productId : productIds )
        {
            productLinks.add("https://www.adidas.ca/api/search/product/" + productId + "?sitePath=en");
        }

        return productLinks;
    }

}
