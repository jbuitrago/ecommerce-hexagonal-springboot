package com.ecommerce.prices.domain.ports.in;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.infrastructure.dtos.PriceOutputDTO;

import java.util.Date;
import java.util.List;

/**
 * Interfaz para el caso de uso de obtener precios.
 */
public interface GetPriceUseCase {

    /**
     * Obtiene una lista de precios por ID de marca, ID de producto y rango de fechas.
     *
     * @param brandId    ID de la marca.
     * @param productId  ID del producto.
     * @param startDate  Fecha de inicio del rango.
     * @param endDate    Fecha de fin del rango.
     * @return Lista de precios que cumplen con los criterios de búsqueda.
     */
    List<PriceOutputDTO> getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long brandId, Long productId, Date startDate, Date endDate);

    /**
     * Obtiene una lista de precios por ID de marca y ID de producto.
     *
     * @param brandId    ID de la marca.
     * @param productId  ID del producto.
     * @return Lista de precios asociados a la marca y producto especificados.
     */
    List<Price> getPricesByBrandIdAndProductId(Long brandId, Long productId);

}
