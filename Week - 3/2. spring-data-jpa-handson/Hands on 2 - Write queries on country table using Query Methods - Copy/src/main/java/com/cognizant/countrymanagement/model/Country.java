package com.cognizant.countrymanagement.model;

import jakarta.persistence.*;

@Entity
public class Country {
    
    @Id
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    // Getter and setter for code
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

