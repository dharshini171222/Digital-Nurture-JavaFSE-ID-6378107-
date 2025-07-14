package com.cognizant.countrymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.countrymanagement.model.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByNameContainingIgnoreCase(String name);
}
