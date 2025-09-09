package com.example.main.controller;

import com.example.main.model.Shipping;
import com.example.main.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    @Autowired
    private ShippingRepository shippingRepository;

    @GetMapping
    public List<Shipping> getAllShipping() {
        return shippingRepository.findAll();
    }

    @PostMapping
    public Shipping createShipping(@RequestBody Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    @GetMapping("/{id}")
    public Shipping getShippingById(@PathVariable Long id) {
        return shippingRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Shipping updateShipping(@PathVariable Long id, @RequestBody Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    @DeleteMapping("/{id}")
    public void deleteShipping(@PathVariable Long id) {
        shippingRepository.deleteById(id);
    }
}
