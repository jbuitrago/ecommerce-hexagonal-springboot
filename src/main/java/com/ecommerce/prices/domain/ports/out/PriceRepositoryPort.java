package com.ecommerce.prices.domain.ports.out;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.infrastructure.entities.PriceEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PriceRepositoryPort {
    Price save(Price price);
    Optional<Price> findById(Long id);
    List<PriceEntity> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long brandId,Long productId, Date startDate, Date endDate);
    List<PriceEntity> findByBrandIdAndProductId(Long brandId,Long productId);

}
