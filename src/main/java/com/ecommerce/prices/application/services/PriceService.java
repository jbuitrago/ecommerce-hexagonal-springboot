package com.ecommerce.prices.application.services;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.domain.ports.in.GetPriceUseCase;
import com.ecommerce.prices.infrastructure.entities.PriceEntity;

import java.util.Optional;
import java.util.List;
import java.util.Date;

public class PriceService implements GetPriceUseCase {

    private final GetPriceUseCase getPriceUseCase;


    public PriceService(GetPriceUseCase getPriceUseCase) {
        this.getPriceUseCase = getPriceUseCase;
    }


    @Override
    public Optional<Price> getPriceById(Long id) {
        return getPriceUseCase.getPriceById(id);
    }

    @Override
    public List<PriceEntity> getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long brandId,Long productId,  Date startDate, Date endDate) {
        return getPriceUseCase.getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId,productId,startDate,endDate);
    }

    @Override
    public List<PriceEntity> getPricesByBrandIdAndProductId(Long brandId,Long productId) {
        return getPriceUseCase.getPricesByBrandIdAndProductId(brandId,productId);
    }
}
