package com.example.main.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Variants")
public class Variants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer variantId;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    // Default constructor
    public Variants() {
    }

    // Parameterized constructor
    public Variants(Integer variantId, Product product, String sku, String color,
                    String size, BigDecimal price, Integer stockQuantity, Boolean isActive) {
        this.variantId = variantId;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
