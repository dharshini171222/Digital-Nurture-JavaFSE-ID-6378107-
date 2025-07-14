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
        // testAddCountry(); // Optional: keep previous test
        testUpdateCountry();
    }

    private void testUpdateCountry() throws CountryNotFoundException {
        LOGGER.info("Start - Update Country");

        // First ensure the country exists (or use an existing one like "IN")
        Country country = new Country("ZZ", "Testland");
        countryService.addCountry(country);

        // Update the country name
        countryService.updateCountry("ZZ", "UpdatedLand");

        // Fetch and print updated country
        Country updatedCountry = countryService.findCountryByCode("ZZ");
        LOGGER.debug("Updated Country: {}", updatedCountry);

        LOGGER.info("End - Update Country");
    }

}
