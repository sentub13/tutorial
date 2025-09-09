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

    public Specifications createSpecification(Specifications specification) {
        return specificationsRepository.save(specification);
    }

    public Optional<Specifications> getSpecificationById(Long id) {
        return specificationsRepository.findById(id);
    }

    public Specifications updateSpecification(Long id, Specifications specification) {
        return specificationsRepository.save(specification);
    }

    public void deleteSpecification(Long id) {
        specificationsRepository.deleteById(id);
    }
}
