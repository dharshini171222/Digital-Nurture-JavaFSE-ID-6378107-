package com.example.springrest.controller;
import com.example.springrest.model.Country;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @RequestMapping("/country")
    public Country getCountryIndia() {
        Country india = new Country();
        india.setCode("IN");
        india.setName("India");
        return india;
    }
}

