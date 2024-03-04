package com.ecommerce.prices.application.services;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.domain.ports.in.GetPriceUseCase;

import java.util.Optional;

public class PriceService implements GetPriceUseCase {

    private final GetPriceUseCase getPriceUseCase;

    public PriceService(GetPriceUseCase getPriceUseCase) {
        this.getPriceUseCase = getPriceUseCase;
    }

    @Override
    public Optional<Price> getPriceById(Long id) {
        return getPriceUseCase.getPriceById(id);
    }
}
