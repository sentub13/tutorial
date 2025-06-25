package com.example.main.service;

import com.example.main.model.Category;
import com.example.main.model.Product;
import com.example.main.model.Seller;
import com.example.main.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAllWithCategoryAndSeller();
    }
    
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findByIdWithCategoryAndSeller(id);
    }
    
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
