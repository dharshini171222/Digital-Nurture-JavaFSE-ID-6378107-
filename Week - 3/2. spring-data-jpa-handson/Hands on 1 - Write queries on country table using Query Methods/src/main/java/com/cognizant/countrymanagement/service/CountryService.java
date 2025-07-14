package com.cognizant.countrymanagement.service;

import com.cognizant.countrymanagement.model.Country;
import com.cognizant.countrymanagement.repository.CountryRepository;
import com.cognizant.countrymanagement.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code " + countryCode + " not found.");
        }
        return result.get();
    }
}
