package com.veera;

import com.veera.controller.RetailWebScrapeController;
import com.veera.model.GroceriesProductList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class RetailWebScrapApplicationTest {

	@InjectMocks
    private RetailWebScrapApplication retailWebScrapApplication;
    @Mock
    private RetailWebScrapeController retailWebScrapeController;
    @Mock
    private ObjectMapper mapper;

	@Test
	public void testRun() throws Exception {
	    retailWebScrapApplication.run();

        verify(mapper).writeValueAsString(any(GroceriesProductList.class));
        verify(retailWebScrapeController).getProductList();
    }
}