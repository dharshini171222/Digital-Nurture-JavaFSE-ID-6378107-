package com.cognizant.countrymanagement.service;

import com.cognizant.countrymanagement.model.Country;
import com.cognizant.countrymanagement.repository.CountryRepository;
import com.cognizant.countrymanagement.service.exception.CountryNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public Country findCountryByCode(String code) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + code);
        }
        return result.get();
    }

    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Optional<Country> optionalCountry = countryRepository.findById(code);

        if (!optionalCountry.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + code);
        }

        Country country = optionalCountry.get();
        country.setName(name); // Update name
        countryRepository.save(country); // Save changes
    }

    @Transactional
    public void deleteCountry(String code) throws CountryNotFoundException {
        if (!countryRepository.existsById(code)) {
            throw new CountryNotFoundException("Country not found with code: " + code);
        }
        countryRepository.deleteById(code);
    }

}
