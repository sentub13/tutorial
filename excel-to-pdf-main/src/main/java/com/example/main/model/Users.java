package com.example.main.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

// Define UserRole enum
enum UserRole {
    ADMIN,
    USER,
    GUEST
}

@Entity
@Table(name = "Users") 
public class Users {       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    private String name;
    
    @Column(unique = true)
    private String email;
    
    private String passwordHash;
    
    private String address;
    
    private String phoneNumber;
    
    @Enumerated(EnumType.STRING)
    private UserRole role;
    
    private LocalDateTime createdAt;

    // Default constructor
    public Users() {
    }

    // Parameterized constructor
    public Users(String name, String email, String passwordHash, String address, String phoneNumber, UserRole role) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
