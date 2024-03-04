package com.ecommerce.prices.domain.ports.out;

import com.ecommerce.prices.domain.models.Price;

import java.util.List;
import java.util.Optional;

public interface PriceRepositoryPort {
    Price save(Price price);
    Optional<Price> findById(Long id);

}
