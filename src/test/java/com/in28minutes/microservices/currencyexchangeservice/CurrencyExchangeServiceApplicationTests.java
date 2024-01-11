package com.in28minutes.microservices.currencyexchangeservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.microservices.currencyexchangeservice.resource.CurrencyExchangeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyExchangeServiceApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Test
	public void contextLoads() {

		LOGGER.info("test file is executing");
	}

}
