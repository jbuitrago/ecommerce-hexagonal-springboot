package com.ecommerce.prices.domain.models;

import com.ecommerce.prices.infrastructure.entities.PriceEntity;

import java.math.BigDecimal;
import java.util.Date;

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

    public static PriceEntity fromDomainModel(Price price) {
        return new PriceEntity(price.getId(), price.getBrandId(), price.getStartDate(),price.getEndDate(),price.getPriceList(),price.getProductId(),price.getPriority(),price.getPrice(),price.getCurrency());
    }

    public Price toDomainModel() {
        return new Price(id,brandId,startDate,endDate,priceList,productId,priority,price,currency);
    }
}