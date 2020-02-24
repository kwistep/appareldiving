package com.appareldiving.adidasdatascraping;

import org.apache.commons.lang3.StringUtils;
import com.appareldiving.adidasdatascraping.util.Entry;
import com.appareldiving.adidasdatascraping.util.GetRequest;
import com.appareldiving.adidasdatascraping.util.RequestUtil;
import com.appareldiving.adidasdatascraping.util.Source;
import com.appareldiving.adidasdatascraping.util.exceptions.InputUrlIsNull;
import com.appareldiving.adidasdatascraping.util.exceptions.UnsupportedUniqueNumberException;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws IOException, InputUrlIsNull, UnsupportedUniqueNumberException {


        GetRequest getRequest = RequestUtil.prepareGetRequest("https://www.adidas.ca/en/men-running-shoes");
        RequestUtil.performRequest(getRequest);
        String response = getRequest.getResponse();


        String articleId = StringUtils.substringBetween(response, "currentProductId\\\":\\\"", "\\\"");
        String title = StringUtils.substringBetween(response, "\"product_information_title___2rG9M product_title gl-heading gl-heading--m\">", "</h1>");
        String brand = "Adidas";
        String priceStr = StringUtils.substringBetween(response, "\"gl-price__value\">C$ ", "</");
        BigDecimal price = BigDecimal.valueOf(Long.parseLong(priceStr));
        String currency = "CAD";
        String color = StringUtils.substringBetween(response, "gl-label gl-label--l gl-vspacing-s color_text___mgoYV\">", "</");
        Source source = new Source();
        source.setLink(getRequest.getUrlConnection().getURL().toString());
        source.setSourceName("Adidas");

        Entry entry = new Entry();
        entry.setArticleId(articleId);
        entry.setProductName(title);
        entry.setBrand(brand);
        entry.setColor(color);
        entry.setCurrency(currency);
        entry.setPrice(price);
        entry.setSource(source);

        entry.createUniqueNumber();

        System.out.println(entry);


//
    }


}
