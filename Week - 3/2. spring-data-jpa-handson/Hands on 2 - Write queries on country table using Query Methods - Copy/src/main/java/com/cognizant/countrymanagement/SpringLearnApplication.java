package com.cognizant.countrymanagement;

import com.cognizant.countrymanagement.model.Country;
import com.cognizant.countrymanagement.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
    }

    @PostConstruct
    public void run() {
        testFindByNameContainingIgnoreCase();
        testFindByNameContainingIgnoreCaseOrderByNameAsc();
        testFindByNameStartingWithIgnoreCase();
    }

    // 1. Search by partial name (e.g., 'ou')
    private void testFindByNameContainingIgnoreCase() {
        System.out.println("=== Countries containing 'ou' (any order) ===");
        List<Country> countries = countryRepository.findByNameContainingIgnoreCase("ou");
        countries.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));
        System.out.println();
    }

    // 2. Search by partial name and return results in ascending order
    private void testFindByNameContainingIgnoreCaseOrderByNameAsc() {
        System.out.println("=== Countries containing 'ou' (ascending order) ===");
        List<Country> countries = countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc("ou");
        countries.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));
        System.out.println();
    }

    // 3. Search by first letter (e.g., 'Z')
    private void testFindByNameStartingWithIgnoreCase() {
        System.out.println("=== Countries starting with 'Z' ===");
        List<Country> countries = countryRepository.findByNameStartingWithIgnoreCase("Z");
        countries.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));
        System.out.println();
    }
}
