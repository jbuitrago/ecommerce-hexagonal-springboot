package com.ecommerce.prices.application.usecases;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.domain.ports.in.GetPriceUseCase;

import java.util.Optional;

public class GetPriceUseCaseImpl implements GetPriceUseCase {

    private final GetPriceUseCase getPriceUseCase;


    public GetPriceUseCaseImpl(GetPriceUseCase getPriceUseCase) {
        this.getPriceUseCase = getPriceUseCase;
    }


    @Override
    public Optional<Price> getPrice(Long id) {
        return Optional.empty();
    }
}

