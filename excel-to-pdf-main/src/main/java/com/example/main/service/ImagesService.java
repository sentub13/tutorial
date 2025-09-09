package com.example.main.service;

import com.example.main.model.Images;
import com.example.main.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagesService {
    @Autowired
    private ImagesRepository imagesRepository;

    public List<Images> getAllImages() {
        return imagesRepository.findAll();
    }

    public Images createImage(Images image) {
        return imagesRepository.save(image);
    }

    public Optional<Images> getImageById(Long id) {
        return imagesRepository.findById(id);
    }

    public Images updateImage(Long id, Images image) {
        return imagesRepository.save(image);
    }

    public void deleteImage(Long id) {
        imagesRepository.deleteById(id);
    }
}
