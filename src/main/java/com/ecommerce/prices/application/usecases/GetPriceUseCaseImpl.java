package com.ecommerce.prices.application.usecases;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.domain.ports.in.GetPriceUseCase;
import com.ecommerce.prices.domain.ports.out.PriceRepositoryPort;

import java.util.Optional;

public class GetPriceUseCaseImpl implements GetPriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    public GetPriceUseCaseImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;


    }

    public Optional<Price> getPriceById(Long id) {
        return priceRepositoryPort.findById(id);
    }

}


