package com.veera.util;

import com.veera.Exception.RetailWebScraperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;

public class RetailWebScrapUtil {
    private final static Logger logger = LoggerFactory.getLogger(RetailWebScrapUtil.class);

    public static BigDecimal parsePrice(String price) {
        return new BigDecimal(price.substring(1, price.indexOf("/")));
    }

    public static String decodeUrl(String url) {
        try {
            url = URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            final String error = String.format("URL decoding is failed: %s", url);
            throw new RetailWebScraperException(error, e);
        }
        return url;
    }


}