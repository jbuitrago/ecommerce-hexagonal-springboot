package com.ecommerce.prices.infrastructure.controllers;

import com.ecommerce.prices.application.services.PriceService;
import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.infrastructure.entities.PriceEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("/pricesByBrandIdAndProductIdAndDate")
    public ResponseEntity<List<PriceEntity>> pricesByBrandIdAndProductIdAndDate(
            @RequestParam("brandId") Long brandId,
            @RequestParam("productId") Long productId,
            @RequestParam("startDate") String startDateStr,
            @RequestParam("endDate") String endDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = dateFormat.parse(startDateStr);
            endDate = dateFormat.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<PriceEntity> prices = priceService.getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, startDate, endDate);
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
    @GetMapping("/pricesByBrandIdAndProductId")
    public ResponseEntity<List<PriceEntity>>getPricesByBrandIdAndProductId(
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {
        List<PriceEntity> prices = priceService.getPricesByBrandIdAndProductId(brandId,productId);
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
    @GetMapping("/ok")
    public String testOk() {
        return "OK";
    }


}
