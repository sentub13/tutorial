package com.example.main.controller;

import com.example.main.model.Images;
import com.example.main.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImagesController {
    @Autowired
    private ImagesRepository imagesRepository;

    @GetMapping
    public List<Images> getAllImages() {
        return imagesRepository.findAll();
    }

    @PostMapping
    public Images createImage(@RequestBody Images image) {
        return imagesRepository.save(image);
    }

    @GetMapping("/{id}")
    public Images getImageById(@PathVariable Long id) {
        return imagesRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Images updateImage(@PathVariable Long id, @RequestBody Images image) {
        return imagesRepository.save(image);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
        imagesRepository.deleteById(id);
    }
}
