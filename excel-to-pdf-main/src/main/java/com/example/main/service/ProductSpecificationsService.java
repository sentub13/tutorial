package com.example.main.service;

import com.example.main.model.ProductSpecifications;
import com.example.main.repository.ProductSpecificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSpecificationsService {
    @Autowired
    private ProductSpecificationsRepository productSpecificationsRepository;

    public List<ProductSpecifications> getAllProductSpecifications() {
        return productSpecificationsRepository.findAll();
    }

    public ProductSpecifications createProductSpecification(ProductSpecifications productSpecification) {
        return productSpecificationsRepository.save(productSpecification);
    }

    public Optional<ProductSpecifications> getProductSpecificationById(Long id) {
        return productSpecificationsRepository.findById(id);
    }

    public ProductSpecifications updateProductSpecification(Long id, ProductSpecifications productSpecification) {
        return productSpecificationsRepository.save(productSpecification);
    }

    public void deleteProductSpecification(Long id) {
        productSpecificationsRepository.deleteById(id);
    }
}

