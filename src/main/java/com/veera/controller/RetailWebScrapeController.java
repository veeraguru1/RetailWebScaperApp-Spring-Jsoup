package com.veera.controller;

import com.veera.model.GroceriesProduct;
import com.veera.model.GroceriesProductList;
import com.veera.services.RetailWebScrapServices;
import com.veera.util.Endpoint;

import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RetailWebScrapeController {
    private final String url = Endpoint.JAVA_TEST_URL.getConstantValue();

    @Autowired
    private RetailWebScrapServices retailWebScrapServices;

    public GroceriesProductList getProductList() {
        final List<Element> elements = retailWebScrapServices.getGroceriesProducts(url);


        List<GroceriesProduct> products = elements.stream()
                .map(element -> retailWebScrapServices.getGroceriesProduct(element.attr("href")))
                .collect(Collectors.toList());

        return new GroceriesProductList(products, retailWebScrapServices.calculateTotalUnitPrice(products));
    }
}