package com.example.main.controller;

import com.example.main.model.Variants;
import com.example.main.service.VariantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/variants")
public class VariantsController {
    @Autowired
    private VariantsService variantsService;

    @GetMapping
    public List<Variants> getAllVariants() {
        return variantsService.getAllVariants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Variants> getVariantById(@PathVariable Integer id) {
        return variantsService.getVariantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Variants createVariant(@RequestBody Variants variant) {
        return variantsService.createVariant(variant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariant(@PathVariable Integer id) {
        variantsService.deleteVariant(id);
        return ResponseEntity.noContent().build();
    }
}
