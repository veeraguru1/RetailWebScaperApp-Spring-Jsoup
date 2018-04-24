package com.veera.services;

import com.veera.Exception.RetailWebScraperException;
import com.veera.model.GroceriesProduct;
import com.veera.util.Endpoint;
import com.veera.util.RetailWebScrapUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class RetailWebScrapServices {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    private final String productSelector = Endpoint.PRODUCT_SELECTOR.getConstantValue();
    private final String titleSelector = Endpoint.TITLE_SELECTOR.getConstantValue();
    private final String descriptionSelector = Endpoint.DESCRIPTION_SELECTOR.getConstantValue();
    private final String pricePerUnitSelector = Endpoint.PRICEPERUNIT_SELECTOR.getConstantValue();

    private Document document;

    public List<Element> getGroceriesProducts(String url) {
        return getDocument(url).select(productSelector);
    }
    public GroceriesProduct getGroceriesProduct(String url) {

        try {
            url = RetailWebScrapUtil.decodeUrl(url);
            document = getDocument(url);


            final Element title = document.select(titleSelector).first();
            final Element description = document.select(descriptionSelector).first();
            final Element pricePerUnit = document.select(pricePerUnitSelector).first();

            return new GroceriesProduct.Builder()
                    .title(title.text())
                    .size(document.outerHtml().length() / 1024 + "kb")
                    .description(description.text())
                    .unitPrice(RetailWebScrapUtil.parsePrice(pricePerUnit.text()))
                    .build();
        } catch (RetailWebScraperException e) {
            logger.error(e.getMessage());
        }
        return null;

    }


    public BigDecimal calculateTotalUnitPrice(List<GroceriesProduct> products) {
        BigDecimal total = BigDecimal.ZERO;
        for (GroceriesProduct product : products) {
            total = total.add(product.getUnitPrice());
        }

        return total;
    }


    private Document getDocument(String url) {
        try {
            document = Jsoup.connect(url).get();

        } catch (IOException e) {
            final String error = String.format("Web document is not found from URL: %s", url);
            throw new RetailWebScraperException(error, e);
        }
        return document;
    }

}
