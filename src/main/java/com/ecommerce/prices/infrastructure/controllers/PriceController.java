package com.ecommerce.prices.infrastructure.controllers;

import com.ecommerce.prices.application.services.PriceService;
import com.ecommerce.prices.domain.models.Price;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }


    @GetMapping("/{priceId}")
    public ResponseEntity<Price> getPriceById(@PathVariable Long priceId) {
        return priceService.getPriceById(priceId)
                .map(price -> new ResponseEntity<>(price, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
