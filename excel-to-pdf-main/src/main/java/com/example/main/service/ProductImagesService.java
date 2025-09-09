package com.example.main.service;

import com.example.main.model.ProductImages;
import com.example.main.repository.ProductImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImagesService {
    @Autowired
    private ProductImagesRepository productImagesRepository;

    public List<ProductImages> getAllProductImages() {
        return productImagesRepository.findAll();
    }

    public ProductImages createProductImage(ProductImages productImage) {
        return productImagesRepository.save(productImage);
    }

    public Optional<ProductImages> getProductImageById(Long id) {
        return productImagesRepository.findById(id);
    }

    public ProductImages updateProductImage(Long id, ProductImages productImage) {
        return productImagesRepository.save(productImage);
    }

    public void deleteProductImage(Long id) {
        productImagesRepository.deleteById(id);
    }
}

