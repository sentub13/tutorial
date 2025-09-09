package com.example.main.service;

import com.example.main.model.Shipping;
import com.example.main.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingService {
    @Autowired
    private ShippingRepository shippingRepository;

    public List<Shipping> getAllShipping() {
        return shippingRepository.findAll();
    }

    public Shipping createShipping(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public Optional<Shipping> getShippingById(Long id) {
        return shippingRepository.findById(id);
    }

    public Shipping updateShipping(Long id, Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    public void deleteShipping(Long id) {
        shippingRepository.deleteById(id);
    }
}

