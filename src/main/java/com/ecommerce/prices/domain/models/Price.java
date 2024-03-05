package com.ecommerce.prices.domain.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Clase que representa un precio en el dominio del modelo.
 */
public class Price {
    private Long id;
    private Long brandId;
    private Date startDate;
    private Date endDate;
    private String priceList;
    private Long productId;
    private int priority;
    private BigDecimal price;
    private String currency;

    /**
     * Constructor de la clase Price.
     *
     * @param id          ID del precio.
     * @param brandId     ID de la marca asociada al precio.
     * @param startDate   Fecha de inicio de validez del precio.
     * @param endDate     Fecha de fin de validez del precio.
     * @param priceList   Lista de precios.
     * @param productId   ID del producto asociado al precio.
     * @param priority    Prioridad del precio.
     * @param price       Valor del precio.
     * @param currency    Moneda del precio.
     */
    public Price(Long id, Long brandId, Date startDate, Date endDate, String priceList, Long productId, int priority, BigDecimal price, String currency) {
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

    // Getters
    public Long getId() {
        return id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getPriceList() {
        return priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public int getPriority() {
        return priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
