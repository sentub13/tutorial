package com.example.main.service;

import com.example.main.model.Images;
import com.example.main.model.Product;
import com.example.main.repository.ImagesRepository;
import com.example.main.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagesService {
    @Autowired
    private ImagesRepository imagesRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Images> getAllImages() {
        return imagesRepository.findAll();
    }

    public List<Images> getImagesByProductId(Integer productId) {
        return imagesRepository.findByProductId(productId);
    }

    public Optional<Images> getImageById(Integer imageId) {
        return imagesRepository.findById(imageId);
    }

    public Images saveImage(Images image) {
        // Optionally check if product exists
        if (image.getProductId() != null) {
            productRepository.findById(image.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        }
        return imagesRepository.save(image);
    }

    public void deleteImage(Integer imageId) {
        imagesRepository.deleteById(imageId);
    }

    public List<Images> getMainImagesByProductId(Integer productId) {
        return imagesRepository.findByProductIdAndIsMain(productId, true);
    }
}
