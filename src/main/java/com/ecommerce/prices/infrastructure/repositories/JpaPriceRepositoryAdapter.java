package com.ecommerce.prices.infrastructure.repositories;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.domain.ports.out.PriceRepositoryPort;
import com.ecommerce.prices.infrastructure.entities.PriceEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Adaptador para el puerto del repositorio de precios que utiliza JPA.
 */
@Component
public class JpaPriceRepositoryAdapter implements PriceRepositoryPort {

    private final JpaPriceRepository jpaPriceRepository;

    /**
     * Constructor que recibe una instancia de JpaPriceRepository.
     *
     * @param jpaPriceRepository Repositorio JPA de precios.
     */
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
    public List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long brandId, Long productId, Date startDate, Date endDate) {
        return jpaPriceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, startDate, endDate);
    }

    @Override
    public List<Price> findByBrandIdAndProductId(Long brandId, Long productId) {
        return jpaPriceRepository.findByBrandIdAndProductId(brandId, productId);
    }
}
