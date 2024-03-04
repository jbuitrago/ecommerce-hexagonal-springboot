package com.ecommerce.prices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ecommerce.prices.application")
public class PricesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricesApplication.class, args);
    }

}
