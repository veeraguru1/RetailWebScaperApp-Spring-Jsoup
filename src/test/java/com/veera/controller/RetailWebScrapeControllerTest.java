package com.veera.controller;


import com.veera.model.GroceriesProduct;
import com.veera.model.GroceriesProductList;
import com.veera.services.RetailWebScrapServices;
import com.veera.util.Endpoint;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RetailWebScrapeControllerTest {
    private final String url = Endpoint.JAVA_TEST_URL.getConstantValue();


    @InjectMocks
    private RetailWebScrapeController retailWebScrapeController;
    @Mock
    private RetailWebScrapServices retailWebScrapServices;
    private ArrayList<Element> elements = new ArrayList<>();

    @Test
    public void testGetProductList()  {
        final GroceriesProduct product = new GroceriesProduct.Builder()
                .title("Test JAVA")
                .description("JAVA TECH Test")
                .size("100kb")
                .unitPrice(new BigDecimal(8))
                .build();

        final Element mockElement = new Element("<a href=http://www.gogle.com>");

        elements.add(mockElement);
        elements.add(mockElement);



        when(retailWebScrapServices.getGroceriesProducts(url)).thenReturn(elements);
        when(retailWebScrapServices.getGroceriesProduct(anyString())).thenReturn(product);
        when(retailWebScrapServices.calculateTotalUnitPrice(any())).thenReturn(new BigDecimal(10));


        final GroceriesProductList productList = retailWebScrapeController.getProductList();

        verify(retailWebScrapServices, times(2)).getGroceriesProduct(anyString());


        assertEquals(product.getTitle(), productList.getProducts().get(0).getTitle());
        assertEquals(product.getDescription(), productList.getProducts().get(0).getDescription());
        assertEquals(product.getSize(), productList.getProducts().get(0).getSize());
        assertEquals(product.getUnitPrice(), productList.getProducts().get(0).getUnitPrice());

        assertEquals(product.getTitle(), productList.getProducts().get(1).getTitle());
        assertEquals(product.getDescription(), productList.getProducts().get(1).getDescription());
        assertEquals(product.getSize(), productList.getProducts().get(1).getSize());
        assertEquals(product.getUnitPrice(), productList.getProducts().get(1).getUnitPrice());



        assertEquals(new BigDecimal(10), productList.getTotal());
    }
}