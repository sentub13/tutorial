package com.example.main.model;

import javax.persistence.*;

@Entity
@Table(name = "Inventory") 
public class Inventory {       
    @Id
    @Column(name = "inventory_id")
    private Integer inventoryId;
    
    @Column(name = "product_id")
    private Integer productId;
    
    @Column(name = "stock_quantity")
    private Integer stockQuantity;
    
    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;
    
    public Inventory() {
    }
    
    public Inventory(Integer inventoryId, Integer productId, Integer stockQuantity) {
        this.inventoryId = inventoryId;
        this.productId = productId;
        this.stockQuantity = stockQuantity;
    }
    
    public Integer getInventoryId() {
        return inventoryId;
    }
    
    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }
    
    public Integer getProductId() {
        return productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public Integer getStockQuantity() {
        return stockQuantity;
    }
    
    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
}