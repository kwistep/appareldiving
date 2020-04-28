package com.appareldiving.databaseservice.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfferDto {

    private int articleId;
    private String offerId;
    private BigDecimal price;
    private BigDecimal salesPrice;
    private String color;
    private Boolean orderable;
    private String productUrl;
    private List<String> productImages;

    public OfferDto() {
    }

    public OfferDto(int articleId, BigDecimal price, BigDecimal salesPrice, String offerId, String color, Boolean orderable, String productUrl, List<String> productImages) {
        this.articleId = articleId;
        this.price = price;
        this.salesPrice = salesPrice;
        this.offerId = offerId;
        this.color = color;
        this.orderable = orderable;
        this.productUrl = productUrl;
        this.productImages = productImages;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getOrderable() {
        return orderable;
    }

    public void setOrderable(Boolean orderable) {
        this.orderable = orderable;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public List<String> getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {

        if( productImages != null ) {
            String[] split = productImages.split("|");
            this.productImages = new ArrayList<>(Arrays.asList(split));
        }
        else
            this.productImages = null;

    }
}
