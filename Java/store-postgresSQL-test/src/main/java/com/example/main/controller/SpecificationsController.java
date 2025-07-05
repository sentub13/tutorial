package com.example.main.controller;

import com.example.main.model.Specifications;
import com.example.main.service.SpecificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/specifications")
public class SpecificationsController {
    @Autowired
    private SpecificationsService specificationsService;

    @GetMapping
    public List<Specifications> getAllSpecifications() {
        return specificationsService.getAllSpecifications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specifications> getSpecificationById(@PathVariable Integer id) {
        Optional<Specifications> spec = specificationsService.getSpecificationById(id);
        return spec.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public List<Specifications> getSpecificationsByProductId(@PathVariable Integer productId) {
        return specificationsService.getSpecificationsByProductId(productId);
    }

    @PostMapping
    public Specifications createSpecification(@RequestBody Specifications spec) {
        return specificationsService.saveSpecification(spec);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specifications> updateSpecification(@PathVariable Integer id, @RequestBody Specifications spec) {
        if (!specificationsService.getSpecificationById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        spec.setSpecId(id);
        return ResponseEntity.ok(specificationsService.saveSpecification(spec));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecification(@PathVariable Integer id) {
        if (!specificationsService.getSpecificationById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        specificationsService.deleteSpecification(id);
        return ResponseEntity.noContent().build();
    }
}
