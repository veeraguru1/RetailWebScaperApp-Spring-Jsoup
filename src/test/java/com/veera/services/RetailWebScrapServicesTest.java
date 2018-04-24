package com.veera.services;

import com.veera.model.GroceriesProduct;
import com.veera.util.Endpoint;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RetailWebScrapServicesTest {
    private final String url = Endpoint.JAVA_TEST_URL.getConstantValue();
    private final String productUrl = "https://www.sainsburys.co.uk/shop/gb/groceries/ripe---ready/sainsburys-avocado--ripe---ready-x2";

    @InjectMocks
    protected RetailWebScrapServices retailWebScrapServices;

    @Test
    public void testGroceriesProductsCount() {
        final List<Element> elements = retailWebScrapServices.getGroceriesProducts(url);

        assertEquals(12, elements.size());
    }

    @Test
    public void testSingleGroceriesProduct()  {
        final GroceriesProduct product = retailWebScrapServices.getGroceriesProduct(productUrl);



        assertEquals("Sainsbury's Avocado, Ripe & Ready x2", product.getTitle());
        assertEquals("52kb", product.getSize());
        assertEquals("Avocados", product.getDescription());
        assertEquals(new BigDecimal("1.90"), product.getUnitPrice());
    }

    @Test
    public void testCalculateTotalUnitPrice()  {
        final GroceriesProduct product = new GroceriesProduct.Builder()
                .unitPrice(new BigDecimal(3.50))
                .build();

        final List<GroceriesProduct> products = new ArrayList<>();
        products.add(product);
        products.add(product);

        assertEquals(new BigDecimal("7.0"), retailWebScrapServices.calculateTotalUnitPrice(products));
    }
}