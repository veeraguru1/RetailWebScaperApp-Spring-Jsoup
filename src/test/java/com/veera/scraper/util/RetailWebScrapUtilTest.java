package com.veera.scraper.util;

import com.veera.util.RetailWebScrapUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RetailWebScrapUtilTest {
    private final String encodedUrl = "https://www.sainsburys.co.uk/shop/gb/groceries/sainsburys-%7Bavocado%7D--ripe---ready-x2";
    private final String decodedUrl = "https://www.sainsburys.co.uk/shop/gb/groceries/sainsburys-{avocado}--ripe---ready-x2";

    @Test
    public void decodeUrl() {

        assertEquals(decodedUrl, RetailWebScrapUtil.decodeUrl(encodedUrl));
    }

    @Test
    public void parsePrice() {
        assertEquals(new BigDecimal("3.50"), RetailWebScrapUtil.parsePrice("£3.50/unit"));
    }
}