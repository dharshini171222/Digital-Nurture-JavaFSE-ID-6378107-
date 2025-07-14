package com.cognizant.countrymanagement.repository;

import com.cognizant.countrymanagement.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
