package com.cognizant.countrymanagement;

import com.cognizant.countrymanagement.model.Country;
import com.cognizant.countrymanagement.service.CountryService;
import com.cognizant.countrymanagement.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }

    @PostConstruct
    public void runTests() throws CountryNotFoundException {
        testAddCountry();
    }

    private void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start");

        Country country = new Country("ZZ", "Testland");
        countryService.addCountry(country);

        Country retrievedCountry = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Added Country: {}", retrievedCountry);

        LOGGER.info("End");
    }
}
