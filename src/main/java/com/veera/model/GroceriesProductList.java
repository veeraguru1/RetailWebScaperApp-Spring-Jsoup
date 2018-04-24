package com.veera.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.util.List;

@JsonPropertyOrder({"results", "total"})
public class GroceriesProductList {

    @JsonProperty("results")
    private List<GroceriesProduct> products;

    private BigDecimal total;

    public GroceriesProductList(List<GroceriesProduct> products, BigDecimal total) {
        this.products = products;
        this.total = total;
    }

    public List<GroceriesProduct> getProducts() {
        return products;
    }

    public void setProducts(List<GroceriesProduct> products) {
        this.products = products;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}