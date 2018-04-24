package com.veera;

import com.veera.controller.RetailWebScrapeController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetailWebScrapApplication implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RetailWebScrapeController retailWebScrapeController;
    @Autowired
    private ObjectMapper mapper;

	public static void main(String[] args) {
		SpringApplication.run(RetailWebScrapApplication.class, args);
	}

    @Override
    public void run(String... strings) {
	    logger.info("Retail Web scrawling process is started");
        try {
            System.out.println(mapper.writeValueAsString(retailWebScrapeController.getProductList()));
        } catch (JsonProcessingException e) {
            final String error = String.format("Converting groceries product list to JSON format process is failed");

            logger.error(error);
            throw new IllegalStateException(error);
        }
        logger.info("Retail Web scrawling process is Ended and application returned JSON format result in console ");
    }
}