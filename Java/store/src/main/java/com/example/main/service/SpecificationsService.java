package com.example.main.service;

import com.example.main.model.Specifications;
import com.example.main.repository.SpecificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecificationsService {
    @Autowired
    private SpecificationsRepository specificationsRepository;

    public List<Specifications> getAllSpecifications() {
        return specificationsRepository.findAll();
    }

    public Optional<Specifications> getSpecificationById(Integer id) {
        return specificationsRepository.findById(id);
    }

    public List<Specifications> getSpecificationsByProductId(Integer productId) {
        return specificationsRepository.findByProductId(productId);
    }

    public Specifications saveSpecification(Specifications spec) {
        return specificationsRepository.save(spec);
    }

    public void deleteSpecification(Integer id) {
        specificationsRepository.deleteById(id);
    }
}
