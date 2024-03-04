package com.ecommerce.prices.domain.ports.in;

import com.ecommerce.prices.domain.models.Price;

import java.util.Optional;

public interface GetPriceUseCase {

    Optional<Price> getPrice(Long id);

}
