package com.example.main.service;

import com.example.main.model.ProductVariants;
import com.example.main.repository.ProductVariantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductVariantsService {
    @Autowired
    private ProductVariantsRepository productVariantsRepository;

    public List<ProductVariants> getAllProductVariants() {
        return productVariantsRepository.findAll();
    }

    public ProductVariants createProductVariant(ProductVariants productVariant) {
        return productVariantsRepository.save(productVariant);
    }

    public Optional<ProductVariants> getProductVariantById(Long id) {
        return productVariantsRepository.findById(id);
    }

    public ProductVariants updateProductVariant(Long id, ProductVariants productVariant) {
        return productVariantsRepository.save(productVariant);
    }

    public void deleteProductVariant(Long id) {
        productVariantsRepository.deleteById(id);
    }
}

