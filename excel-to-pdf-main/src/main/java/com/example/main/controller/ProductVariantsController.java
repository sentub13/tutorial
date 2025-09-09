package com.example.main.controller;

import com.example.main.model.ProductVariants;
import com.example.main.repository.ProductVariantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-variants")
public class ProductVariantsController {
    @Autowired
    private ProductVariantsRepository productVariantsRepository;

    @GetMapping
    public List<ProductVariants> getAllProductVariants() {
        return productVariantsRepository.findAll();
    }

    @PostMapping
    public ProductVariants createProductVariant(@RequestBody ProductVariants productVariant) {
        return productVariantsRepository.save(productVariant);
    }

    @GetMapping("/{id}")
    public ProductVariants getProductVariantById(@PathVariable Long id) {
        return productVariantsRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ProductVariants updateProductVariant(@PathVariable Long id, @RequestBody ProductVariants productVariant) {
        return productVariantsRepository.save(productVariant);
    }

    @DeleteMapping("/{id}")
    public void deleteProductVariant(@PathVariable Long id) {
        productVariantsRepository.deleteById(id);
    }
}
