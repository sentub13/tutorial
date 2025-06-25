package com.example.main.controller;

import com.example.main.model.Seller;
import com.example.main.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    
    @Autowired
    private SellerService sellerService;
    
    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Integer id) {
        return sellerService.getSellerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.saveSeller(seller);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Integer id, @RequestBody Seller sellerUpdate) {
        return sellerService.getSellerById(id)
                .map(seller -> {
                    seller.setName(sellerUpdate.getName());
                    seller.setEmail(sellerUpdate.getEmail());
                    seller.setPhone(sellerUpdate.getPhone());
                    return ResponseEntity.ok(sellerService.saveSeller(seller));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSeller(@PathVariable Integer id) {
        sellerService.deleteSeller(id);
        return ResponseEntity.ok().build();
    }
}
