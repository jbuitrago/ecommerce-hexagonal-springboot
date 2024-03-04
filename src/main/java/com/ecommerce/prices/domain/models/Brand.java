package com.ecommerce.prices.domain.models;

import java.math.BigDecimal;
import java.util.Date;

public class Brand {
    private Long id;

    private String name;


    public Brand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}