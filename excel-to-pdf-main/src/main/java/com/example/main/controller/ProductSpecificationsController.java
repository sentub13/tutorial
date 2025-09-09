package com.example.main.controller;

import com.example.main.model.ProductSpecifications;
import com.example.main.repository.ProductSpecificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-specifications")
public class ProductSpecificationsController {
    @Autowired
    private ProductSpecificationsRepository productSpecificationsRepository;

    @GetMapping
    public List<ProductSpecifications> getAllProductSpecifications() {
        return productSpecificationsRepository.findAll();
    }

    @PostMapping
    public ProductSpecifications createProductSpecification(@RequestBody ProductSpecifications productSpecification) {
        return productSpecificationsRepository.save(productSpecification);
    }

    @GetMapping("/{id}")
    public ProductSpecifications getProductSpecificationById(@PathVariable Long id) {
        return productSpecificationsRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ProductSpecifications updateProductSpecification(@PathVariable Long id, @RequestBody ProductSpecifications productSpecification) {
        return productSpecificationsRepository.save(productSpecification);
    }

    @DeleteMapping("/{id}")
    public void deleteProductSpecification(@PathVariable Long id) {
        productSpecificationsRepository.deleteById(id);
    }
}
