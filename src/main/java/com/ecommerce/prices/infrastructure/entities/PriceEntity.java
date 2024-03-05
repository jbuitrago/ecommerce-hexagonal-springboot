package com.ecommerce.prices.infrastructure.entities;

import com.ecommerce.prices.domain.models.Price;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entidad que representa un precio en la capa de infraestructura.
 */
@Entity
@Table(name = "prices")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long brandId;
    private Date startDate;
    private Date endDate;
    private String priceList;
    private Long productId;
    private int priority;
    private BigDecimal price;
    private String currency;

    // Getters y setters omitidos por brevedad...

    /**
     * Constructor vacío por defecto.
     */
    public PriceEntity() {
    }

    /**
     * Constructor con parámetros para inicializar los atributos de la entidad.
     *
     * @param id         ID del precio.
     * @param brandId    ID de la marca asociada al precio.
     * @param startDate  Fecha de inicio de validez del precio.
     * @param endDate    Fecha de fin de validez del precio.
     * @param priceList  Lista de precios.
     * @param productId  ID del producto asociado al precio.
     * @param priority   Prioridad del precio.
     * @param price      Valor del precio.
     * @param currency   Moneda del precio.
     */
    public PriceEntity(Long id, Long brandId, Date startDate, Date endDate, String priceList, Long productId, int priority, BigDecimal price, String currency) {
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    /**
     * Método estático para convertir un objeto de dominio Price a un objeto de entidad PriceEntity.
     *
     * @param price Objeto Price de dominio.
     * @return Objeto PriceEntity creado a partir del objeto de dominio Price.
     */
    public static PriceEntity fromDomainModel(Price price) {
        return new PriceEntity(price.getId(), price.getBrandId(), price.getStartDate(), price.getEndDate(), price.getPriceList(), price.getProductId(), price.getPriority(), price.getPrice(), price.getCurrency());
    }

    /**
     * Método para convertir un objeto de entidad PriceEntity a un objeto de dominio Price.
     *
     * @return Objeto Price creado a partir del objeto de entidad PriceEntity.
     */
    public Price toDomainModel() {
        return new Price(id, brandId, startDate, endDate, priceList, productId, priority, price, currency);
    }
}
