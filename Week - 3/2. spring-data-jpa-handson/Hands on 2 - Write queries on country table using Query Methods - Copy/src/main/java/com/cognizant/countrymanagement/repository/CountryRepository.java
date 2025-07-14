package com.cognizant.countrymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.countrymanagement.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    //  Partial match on country name (case-insensitive)
    List<Country> findByNameContainingIgnoreCase(String keyword);

    // Partial match sorted in ascending order
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String keyword);

    //  Find by first letter of country name (case-insensitive)
    List<Country> findByNameStartingWithIgnoreCase(String startingLetter);
}
