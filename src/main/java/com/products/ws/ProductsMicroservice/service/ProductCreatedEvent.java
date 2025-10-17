package com.products.ws.ProductsMicroservice.service;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ProductCreatedEvent {

    private String title;
    private BigDecimal price;
    private BigInteger quantity;
    private String productId;

    public ProductCreatedEvent() {
    }

    public ProductCreatedEvent(String title, BigDecimal price, BigInteger quantity, String productId) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
