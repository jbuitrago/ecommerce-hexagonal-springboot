package com.ecommerce.prices.application.usecases;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.domain.ports.in.GetPriceUseCase;
import com.ecommerce.prices.domain.ports.out.PriceRepositoryPort;
import com.ecommerce.prices.infrastructure.entities.PriceEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class GetPriceUseCaseImpl implements GetPriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    public GetPriceUseCaseImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;


    }
    @Override
    public Optional<Price> getPriceById(Long id) {
        return priceRepositoryPort.findById(id);
    }


    @Override
    public List<PriceEntity> getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long brandId,Long productId,  Date startDate, Date endDate) {
        return priceRepositoryPort.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId,productId,  startDate, endDate);
    }

    @Override
    public List<PriceEntity> getPricesByBrandIdAndProductId(Long brandId,Long productId) {
        return priceRepositoryPort.findByBrandIdAndProductId(brandId,productId);
    }

}


