package com.example.main.model;

import javax.persistence.*;

@Entity
@Table(name = "Specifications") 
public class Specifications {
    
    @Id
    @Column(name = "spec_id")
    private Integer specId;
    
    @Column(name = "product_id")
    private Integer productId;
    
    @Column(name = "key_name")
    private String keyName;
    
    @Column(name = "value")
    @Lob
    private String value;
    
    // Default constructor
    public Specifications() {
    }
    
    // Parameterized constructor
    public Specifications(Integer specId, Integer productId, String keyName, String value) {
        this.specId = specId;
        this.productId = productId;
        this.keyName = keyName;
        this.value = value;
    }
    
    // Getters and Setters
    public Integer getSpecId() {
        return specId;
    }
    
    public void setSpecId(Integer specId) {
        this.specId = specId;
    }
    
    public Integer getProductId() {
        return productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public String getKeyName() {
        return keyName;
    }
    
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}