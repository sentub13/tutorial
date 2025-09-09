package com.example.main.controller;

import com.example.main.model.Seller;
import com.example.main.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    @Autowired
    private SellerRepository sellerRepository;

    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @PostMapping
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerRepository.save(seller);
    }

    @GetMapping("/{id}")
    public Seller getSellerById(@PathVariable Long id) {
        return sellerRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Seller updateSeller(@PathVariable Long id, @RequestBody Seller seller) {
        return sellerRepository.save(seller);
    }

    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable Long id) {
        sellerRepository.deleteById(id);
    }
}
