package com.appareldiving.adidasdatascraping.util;


import org.apache.commons.lang3.StringUtils;
import com.appareldiving.adidasdatascraping.util.exceptions.UnsupportedUniqueNumberException;

import java.math.BigDecimal;
import java.util.List;

public class Entry {

    private String uniqueNumber;
    private String articleId;
    private String productName;
    private String brand;
    private BigDecimal price;
    private String currency;
    private List<String> imagesUrl;
    private String color;
    private Source source;

    public Entry() {
    }

    public Entry(String articleId, String productName, String brand, BigDecimal price, String currency, List<String> imagesUrl, String color, Source source) {
        this.articleId = articleId;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.currency = currency;
        this.imagesUrl = imagesUrl;
        this.color = color;
        this.source = source;
    }

    public void createUniqueNumber() throws UnsupportedUniqueNumberException {
        if( source == null || StringUtils.isBlank(source.getSourceName()) || StringUtils.isBlank(articleId) )
        {
            throw new UnsupportedUniqueNumberException("Wrong article id!");
        }
       this.uniqueNumber = source.getSourceName() + "_" + articleId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(List<String> imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    private void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "uniqueNumber='" + uniqueNumber + '\'' +
                ", articleId='" + articleId + '\'' +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", imagesUrl=" + imagesUrl +
                ", color='" + color + '\'' +
                ", source=" + source +
                '}';
    }
}
