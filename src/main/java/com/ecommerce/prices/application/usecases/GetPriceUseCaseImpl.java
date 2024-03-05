package com.ecommerce.prices.application.usecases;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.domain.ports.in.GetPriceUseCase;
import com.ecommerce.prices.domain.ports.out.PriceRepositoryPort;

import java.util.Date;
import java.util.List;

/**
 * Implementación del caso de uso para obtener precios.
 */
public class GetPriceUseCaseImpl implements GetPriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    /**
     * Constructor que recibe un puerto para acceder al repositorio de precios.
     *
     * @param priceRepositoryPort Puerto para acceder al repositorio de precios.
     */
    public GetPriceUseCaseImpl(PriceRepositoryPort priceRepositoryPort) {
        this.priceRepositoryPort = priceRepositoryPort;
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
        return priceRepositoryPort.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, startDate, endDate);
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
        return priceRepositoryPort.findByBrandIdAndProductId(brandId, productId);
    }
}
