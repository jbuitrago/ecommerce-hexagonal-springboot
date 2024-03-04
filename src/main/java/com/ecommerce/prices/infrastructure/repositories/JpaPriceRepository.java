package com.ecommerce.prices.infrastructure.repositories;

import com.ecommerce.prices.infrastructure.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {
}
