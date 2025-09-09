package com.example.main.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Variants")
public class Variants {
    
    @Id
    @Column(name = "variant_id")
    private Integer variantId;
    
    @Column(name = "product_id")
    private Integer productId;
    
    @Column(name = "sku", unique = true)
    private String sku;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "size")
    private String size;
    
    @Column(name = "price")
    private BigDecimal price;
    
    @Column(name = "stock_quantity")
    private Integer stockQuantity;
    
    @Column(name = "is_active")
    private Boolean isActive;
    
    // Default constructor
    public Variants() {
    }
    
    // Parameterized constructor
    public Variants(Integer variantId, Integer productId, String sku, String color, 
                          String size, BigDecimal price, Integer stockQuantity, Boolean isActive) {
        this.variantId = variantId;
        this.productId = productId;
        this.sku = sku;
        this.color = color;
        this.size = size;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.isActive = isActive;
    }
    
    // Getters and Setters
    public Integer getVariantId() {
        return variantId;
    }
    
    public void setVariantId(Integer variantId) {
        this.variantId = variantId;
    }
    
    public Integer getProductId() {
        return productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public String getSku() {
        return sku;
    }
    
    public void setSku(String sku) {
        this.sku = sku;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Integer getStockQuantity() {
        return stockQuantity;
    }
    
    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}