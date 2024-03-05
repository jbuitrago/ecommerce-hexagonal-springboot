package com.ecommerce.prices.infrastructure.repositories;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.infrastructure.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {
  List<PriceEntity> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc (Long brandId, Long productId, Date startDate, Date endDate);
  List<PriceEntity> findByBrandIdAndProductId(Long brandId,Long productId);

}
