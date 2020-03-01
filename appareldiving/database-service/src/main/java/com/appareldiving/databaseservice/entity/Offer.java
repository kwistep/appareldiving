package com.appareldiving.databaseservice.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue
    private String productId;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "sales_price")
    private BigDecimal salesPrice;

    @Column(name = "color")
    private String color;

    @Column(name = "orderable")
    private Boolean orderable;

    @Column(name = "product_url")
    private String productUrl;

    private List<String> productImages;

    public Offer() {
    }

    public Offer(BigDecimal price, BigDecimal salesPrice, String productId, String color, Boolean orderable, String productUrl, List<String> productImages) {
        this.price = price;
        this.salesPrice = salesPrice;
        this.productId = productId;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
