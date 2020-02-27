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
    public List<String> collectProductLinks(String navigationLink) throws IOException, InputUrlIsNull {
        String response = performRequest(navigationLink);
        List<String> productIds = extractProductIds(response);
        return buildProductLink(productIds);
    }


    private String performRequest(String navigationLink) throws IOException, InputUrlIsNull
    {
        GetRequest getRequest = RequestUtil.prepareGetRequest(navigationLink);
        RequestUtil.performRequest(getRequest);
        return getRequest.getResponse();
    }

    private List<String> extractProductIds(String response)
    {
        String[] productIds = StringUtils.substringsBetween(response, "productId\\\":\\\"", "\\\",");
        return Arrays.asList(productIds);
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
