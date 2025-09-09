package com.example.main.controller;

import com.example.main.model.Specifications;
import com.example.main.repository.SpecificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specifications")
public class SpecificationsController {
    @Autowired
    private SpecificationsRepository specificationsRepository;

    @GetMapping
    public List<Specifications> getAllSpecifications() {
        return specificationsRepository.findAll();
    }

    @PostMapping
    public Specifications createSpecification(@RequestBody Specifications specification) {
        return specificationsRepository.save(specification);
    }

    @GetMapping("/{id}")
    public Specifications getSpecificationById(@PathVariable Long id) {
        return specificationsRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Specifications updateSpecification(@PathVariable Long id, @RequestBody Specifications specification) {
        return specificationsRepository.save(specification);
    }

    @DeleteMapping("/{id}")
    public void deleteSpecification(@PathVariable Long id) {
        specificationsRepository.deleteById(id);
    }
}
