package com.appareldiving.dataconsolidationservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "products")
public class Offer {

    @Id
    private String OfferId;
    private BigDecimal price;
    private BigDecimal salesPrice;
    private String color;
    private Boolean orderable;
    private String productUrl;
    private List<String> productImages;


    public Offer() {
    }

    public Offer(String OfferId, BigDecimal price, BigDecimal salesPrice, String color, Boolean orderable, String productUrl, List<String> productImages) {
        this.OfferId = OfferId;
        this.price = price;
        this.salesPrice = salesPrice;
        this.color = color;
        this.orderable = orderable;
        this.productUrl = productUrl;
        this.productImages = productImages;
    }

    public String getOfferId() {
        return OfferId;
    }

    public void setOfferId(String offerId) {
        this.OfferId = offerId;
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
