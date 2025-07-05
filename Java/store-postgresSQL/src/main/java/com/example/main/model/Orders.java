package com.example.main.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
public class Orders {
    
    @Id
    @Column(name = "order_id")
    private Integer orderId;
    
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;
    
    @Column(name = "shipping_address", columnDefinition = "TEXT")
    private String shippingAddress;
    
    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;
    
    // Enum for order status
    public enum OrderStatus {
        pending, shipped, delivered, cancelled
    }
    
    // Default constructor
    public Orders() {
    }
    
    // Parameterized constructor
    public Orders(Integer orderId, Integer userId, LocalDateTime orderDate, OrderStatus status, 
                 String shippingAddress, BigDecimal totalAmount) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.totalAmount = totalAmount;
    }
    
    // Getters and Setters
    public Integer getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    
    public OrderStatus getStatus() {
        return status;
    }
    
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    
    public String getShippingAddress() {
        return shippingAddress;
    }
    
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}