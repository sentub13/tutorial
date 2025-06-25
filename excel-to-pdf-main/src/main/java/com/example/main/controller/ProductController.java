package com.example.main.controller;

import com.example.main.model.Product;
import com.example.main.service.ProductService;
import com.example.main.service.CategoryService;
import com.example.main.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private SellerService sellerService;
    
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Map<String, Object> productData) {
        try {
            Product product = new Product();
            product.setName((String) productData.get("name"));
            product.setDescription((String) productData.get("description"));
            product.setPrice(new java.math.BigDecimal(productData.get("price").toString()));
            product.setStockQuantity((Integer) productData.get("stockQuantity"));
            
            Integer categoryId = (Integer) productData.get("categoryId");
            Integer sellerId = (Integer) productData.get("sellerId");
            
            return categoryService.getCategoryById(categoryId)
                .flatMap(category -> sellerService.getSellerById(sellerId)
                    .map(seller -> {
                        product.setCategory(category);
                        product.setSeller(seller);
                        return ResponseEntity.ok(productService.saveProduct(product));
                    }))
                .orElse(ResponseEntity.badRequest().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return productService.getProductById(id)
                .map(existing -> {
                    product.setProductId(id);
                    return ResponseEntity.ok(productService.saveProduct(product));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        if (productService.getProductById(id).isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}