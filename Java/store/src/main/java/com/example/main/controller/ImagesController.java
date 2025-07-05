package com.example.main.controller;

import com.example.main.model.Images;
import com.example.main.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
    @Autowired
    private ImagesService imagesService;

    @GetMapping
    public List<Images> getAllImages() {
        return imagesService.getAllImages();
    }

    @GetMapping("/product/{productId}")
    public List<Images> getImagesByProductId(@PathVariable Integer productId) {
        return imagesService.getImagesByProductId(productId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Images> getImageById(@PathVariable Integer id) {
        return imagesService.getImageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Images createImage(@RequestBody Images image) {
        return imagesService.saveImage(image);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Images> updateImage(@PathVariable Integer id, @RequestBody Images image) {
        return imagesService.getImageById(id)
                .map(existing -> {
                    image.setImageId(id);
                    return ResponseEntity.ok(imagesService.saveImage(image));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Integer id) {
        imagesService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/product/{productId}/main")
    public List<Images> getMainImagesByProductId(@PathVariable Integer productId) {
        return imagesService.getMainImagesByProductId(productId);
    }
}
