package com.ecommerce.prices.application.services;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.domain.ports.in.GetPriceUseCase;
import java.util.Optional;
import java.util.List;
import java.util.Date;

/**
 * Servicio para gestionar precios en la aplicación.
 */
public class PriceService implements GetPriceUseCase {

    private final GetPriceUseCase getPriceUseCase;

    /**
     * Constructor que recibe una implementación del caso de uso para obtener precios.
     *
     * @param getPriceUseCase Caso de uso para obtener precios.
     */
    public PriceService(GetPriceUseCase getPriceUseCase) {
        this.getPriceUseCase = getPriceUseCase;
    }

    /**
     * Obtiene una lista de precios por ID de marca, ID de producto y rango de fechas.
     *
     * @param brandId    ID de la marca.
     * @param productId  ID del producto.
     * @param startDate  Fecha de inicio del rango.
     * @param endDate    Fecha de fin del rango.
     * @return Lista de precios que cumplen con los criterios de búsqueda.
     */
    @Override
    public List<Price> getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long brandId, Long productId, Date startDate, Date endDate) {
        return getPriceUseCase.getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, startDate, endDate);
    }

    /**
     * Obtiene una lista de precios por ID de marca y ID de producto.
     *
     * @param brandId    ID de la marca.
     * @param productId  ID del producto.
     * @return Lista de precios asociados a la marca y producto especificados.
     */
    @Override
    public List<Price> getPricesByBrandIdAndProductId(Long brandId, Long productId) {
        return getPriceUseCase.getPricesByBrandIdAndProductId(brandId, productId);
    }
}
