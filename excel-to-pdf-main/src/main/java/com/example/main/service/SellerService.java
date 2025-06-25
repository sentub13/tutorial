package com.example.main.service;

import com.example.main.model.Seller;
import com.example.main.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {
    
    @Autowired
    private SellerRepository sellerRepository;
    
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }
    
    public Optional<Seller> getSellerById(Integer id) {
        return sellerRepository.findById(id);
    }
    
    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
    
    public void deleteSeller(Integer id) {
        sellerRepository.deleteById(id);
    }
}
