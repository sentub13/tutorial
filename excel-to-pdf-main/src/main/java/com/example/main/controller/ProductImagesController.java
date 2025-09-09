package com.example.main.controller;

import com.example.main.model.ProductImages;
import com.example.main.repository.ProductImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-images")
public class ProductImagesController {
    @Autowired
    private ProductImagesRepository productImagesRepository;

    @GetMapping
    public List<ProductImages> getAllProductImages() {
        return productImagesRepository.findAll();
    }

    @PostMapping
    public ProductImages createProductImage(@RequestBody ProductImages productImage) {
        return productImagesRepository.save(productImage);
    }

    @GetMapping("/{id}")
    public ProductImages getProductImageById(@PathVariable Long id) {
        return productImagesRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ProductImages updateProductImage(@PathVariable Long id, @RequestBody ProductImages productImage) {
        return productImagesRepository.save(productImage);
    }

    @DeleteMapping("/{id}")
    public void deleteProductImage(@PathVariable Long id) {
        productImagesRepository.deleteById(id);
    }
}
