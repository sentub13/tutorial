package com.example.main.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Shipping")
public class Shipping {
    
    @Id
    @Column(name = "shipping_id")
    private Integer shippingId;
    
    @Column(name = "order_id")
    private Integer orderId;
    
    @Column(name = "carrier", length = 100)
    private String carrier;
    
    @Column(name = "tracking_number", length = 100)
    private String trackingNumber;
    
    @Column(name = "estimated_delivery")
    private LocalDate estimatedDelivery;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ShippingStatus status;
    
    // Enum for shipping status
    public enum ShippingStatus {
        in_transit, delivered, delayed
    }
    
    // Default constructor
    public Shipping() {
    }
    
    // Parameterized constructor
    public Shipping(Integer shippingId, Integer orderId, String carrier, String trackingNumber, 
                   LocalDate estimatedDelivery, ShippingStatus status) {
        this.shippingId = shippingId;
        this.orderId = orderId;
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
        this.estimatedDelivery = estimatedDelivery;
        this.status = status;
    }
    
    // Getters and Setters
    public Integer getShippingId() {
        return shippingId;
    }
    
    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }
    
    public Integer getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    public String getCarrier() {
        return carrier;
    }
    
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    
    public String getTrackingNumber() {
        return trackingNumber;
    }
    
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
    
    public LocalDate getEstimatedDelivery() {
        return estimatedDelivery;
    }
    
    public void setEstimatedDelivery(LocalDate estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }
    
    public ShippingStatus getStatus() {
        return status;
    }
    
    public void setStatus(ShippingStatus status) {
        this.status = status;
    }
}