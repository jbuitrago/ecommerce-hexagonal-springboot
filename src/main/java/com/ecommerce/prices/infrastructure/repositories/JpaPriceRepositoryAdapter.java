package com.ecommerce.prices.infrastructure.repositories;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.domain.ports.out.PriceRepositoryPort;
import com.ecommerce.prices.infrastructure.entities.PriceEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaPriceRepositoryAdapter implements PriceRepositoryPort {

    private final JpaPriceRepository jpaPriceRepository;

    public JpaPriceRepositoryAdapter(JpaPriceRepository jpaPriceRepository) {
        this.jpaPriceRepository = jpaPriceRepository;
    }

    @Override
    public Price save(Price price) {
        PriceEntity priceEntity = PriceEntity.fromDomainModel(price);
        PriceEntity savedPriceEntity = jpaPriceRepository.save(priceEntity);
        return savedPriceEntity.toDomainModel();

    }

    @Override
    public Optional<Price> findById(Long id) {
        return jpaPriceRepository.findById(id).map(PriceEntity::toDomainModel);
    }



}
