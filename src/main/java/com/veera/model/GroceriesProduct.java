package com.veera.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

@JsonPropertyOrder({"title", "size", "unitPrice", "description"})
public class GroceriesProduct {
    private String title;
    private String size;
    private String description;

    @JsonProperty("unit_price")
    private BigDecimal unitPrice;



    public GroceriesProduct() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public GroceriesProduct(Builder builder) {
        this.title = builder.title;
        this.size = builder.size;
        this.unitPrice = builder.unitPrice;
        this.description = builder.description;
    }


    public static class Builder {
        @JsonPropertyOrder({ "title", "size", "unit_price", "description" })
        private String title;
        private String size;
        private BigDecimal unitPrice;
        private String description;



        public Builder title(String title) {
           this.title = title;
           return this;
        }

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder unitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public GroceriesProduct build() {
            return new GroceriesProduct(this);
        }
    }
}