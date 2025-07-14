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
        // testAddCountry();
        // testUpdateCountry();
        testDeleteCountry();
    }

    private void testDeleteCountry() throws CountryNotFoundException {
        LOGGER.info("Start - Delete Country");

        // Add country first (optional if already added previously)
        Country country = new Country("ZZ", "ToBeDeleted");
        countryService.addCountry(country);

        // Now delete it
        countryService.deleteCountry("ZZ");

        // Try to fetch and handle exception
        try {
            Country deletedCountry = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Country still exists: {}", deletedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.info("Country with code ZZ successfully deleted.");
        }

        LOGGER.info("End - Delete Country");
    }

}
