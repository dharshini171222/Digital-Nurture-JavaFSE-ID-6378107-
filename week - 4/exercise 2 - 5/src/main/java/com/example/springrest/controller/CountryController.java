package com.example.springrest.controller;
import com.example.springrest.model.Country;
import com.example.springrest.exception.CountryNotFoundException;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CountryController {
@GetMapping("/countries")
public List<Country> getAllCountries() {
    List<Country> countries = new ArrayList<>();
    
    Country india = new Country();
    india.setCode("IN");
    india.setName("India");

    Country us = new Country();
    us.setCode("US");
    us.setName("United States");

    Country jp = new Country();
    jp.setCode("JP");
    jp.setName("Japan");

    Country de = new Country();
    de.setCode("DE");
    de.setName("Germany");

    countries.add(india);
    countries.add(us);
    countries.add(jp);
    countries.add(de);
    return countries;
}
    @GetMapping("/countries/{code}")
public Country getCountry(@PathVariable String code) {
    List<Country> countries = getAllCountries(); // reuse your list method

    for (Country country : countries) {
        if (country.getCode().equalsIgnoreCase(code)) {
            return country;
        }
    }

    throw new CountryNotFoundException();
}
}


