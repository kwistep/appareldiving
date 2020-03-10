package com.appareldiving.dataparsingservice.dto;


import java.math.BigDecimal;
import java.util.List;

public class Offer {

    private BigDecimal price;
    private BigDecimal salesPrice;
    private String offerId;
    private String color;
    private Boolean orderable;
    private String productUrl;
    private List<String> productImages;

    public Offer() {
    }

    public Offer(BigDecimal price, BigDecimal salesPrice, String offerId, String color, Boolean orderable, String productUrl, List<String> productImages) {
        this.price = price;
        this.salesPrice = salesPrice;
        this.offerId = offerId;
        this.color = color;
        this.orderable = orderable;
        this.productUrl = productUrl;
        this.productImages = productImages;
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

    public void setProductImages(List<String> productImages) {
        this.productImages = productImages;
    }
}
