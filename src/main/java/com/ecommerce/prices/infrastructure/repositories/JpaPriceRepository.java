package com.ecommerce.prices.infrastructure.repositories;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.infrastructure.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Interfaz de repositorio JPA para la entidad PriceEntity.
 */
@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {

  /**
   * Busca una lista de precios por ID de marca, ID de producto y rango de fechas ordenados por prioridad de forma descendente.
   *
   * @param brandId    ID de la marca.
   * @param productId  ID del producto.
   * @param startDate  Fecha de inicio del rango.
   * @param endDate    Fecha de fin del rango.
   * @return Lista de precios que cumplen con los criterios de búsqueda.
   */
  List<Price> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long brandId, Long productId, Date startDate, Date endDate);

  /**
   * Busca una lista de precios por ID de marca y ID de producto.
   *
   * @param brandId    ID de la marca.
   * @param productId  ID del producto.
   * @return Lista de precios asociados a la marca y producto especificados.
   */
  List<Price> findByBrandIdAndProductId(Long brandId, Long productId);
}
