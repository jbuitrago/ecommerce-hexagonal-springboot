package com.ecommerce.prices.infrastructure.entities;

import com.ecommerce.prices.domain.models.Price;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPriceList() {
        return priceList;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    private String currency;

    public PriceEntity() {
    }

    public PriceEntity(Long id,Long brandId,Date startDate,Date endDate,String priceList,Long productId,int priority,BigDecimal price,String currency) {
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
    public static PriceEntity fromDomainModel(Price price) {
        return new PriceEntity(price.getId(), price.getBrandId(),price.getStartDate(),price.getEndDate(), price.getPriceList(), price.getProductId(), price.getPriority(),price.getPrice(), price.getCurrency());
    }

    public Price toDomainModel() {
        return new Price(id,brandId,startDate,endDate,priceList,productId,priority,price,currency);
    }


}

























