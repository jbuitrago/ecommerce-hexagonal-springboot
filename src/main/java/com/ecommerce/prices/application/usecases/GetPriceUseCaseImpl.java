package com.ecommerce.prices.application.usecases;

import com.ecommerce.prices.domain.models.Price;
import com.ecommerce.prices.domain.ports.in.GetPriceUseCase;
import com.ecommerce.prices.domain.ports.out.PriceRepositoryPort;
import com.ecommerce.prices.infrastructure.dtos.PriceOutputDTO;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<PriceOutputDTO> getPricesByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long brandId, Long productId, Date startDate, Date endDate) {
        // Lógica para obtener los precios de PriceRepository o servicio equivalente
        List<Price> prices = priceRepositoryPort.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(brandId, productId, startDate, endDate);

        // Mapear objetos Price a PriceDTO

        return prices.stream()
                .map(price -> new PriceOutputDTO(
                        price.getProductId(),
                        price.getBrandId(),
                        price.getPriceList(),
                        price.getStartDate(),
                        price.getEndDate(),
                        price.getPrice()
                ))
                .collect(Collectors.toList());
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
