package com.example.main.controller;

import com.example.main.model.Variants;
import com.example.main.repository.VariantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variants")
public class VariantsController {
    @Autowired
    private VariantsRepository variantsRepository;

    @GetMapping
    public List<Variants> getAllVariants() {
        return variantsRepository.findAll();
    }

    @PostMapping
    public Variants createVariant(@RequestBody Variants variant) {
        return variantsRepository.save(variant);
    }

    @GetMapping("/{id}")
    public Variants getVariantById(@PathVariable Long id) {
        return variantsRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Variants updateVariant(@PathVariable Long id, @RequestBody Variants variant) {
        return variantsRepository.save(variant);
    }

    @DeleteMapping("/{id}")
    public void deleteVariant(@PathVariable Long id) {
        variantsRepository.deleteById(id);
    }
}
