package com.cognizant.countrymanagement;

import com.cognizant.countrymanagement.model.Country;
import com.cognizant.countrymanagement.service.CountryService;
import com.cognizant.countrymanagement.service.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) throws CountryNotFoundException {
        ApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        getCountryTest();
    }

    private static void getCountryTest() throws CountryNotFoundException {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End");
    }
}
