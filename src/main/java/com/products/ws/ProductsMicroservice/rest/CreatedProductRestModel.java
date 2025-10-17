package com.products.ws.ProductsMicroservice.rest;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CreatedProductRestModel {

    private String title;
    private BigDecimal price;
    private BigInteger quantity;

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
}
