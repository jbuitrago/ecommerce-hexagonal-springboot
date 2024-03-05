package com.ecommerce.prices.domain.ports.in;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.infrastructure.entities.PriceEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface GetPriceUseCase {

    Optional<Price> getPriceById(Long id);

    List<PriceEntity> getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long brandId,Long productId, Date startDate, Date endDate);
    List<PriceEntity> getPricesByBrandIdAndProductId(Long brandId,Long productId);

}
