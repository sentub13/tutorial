package com.example.main.service;

import com.example.main.model.Variants;
import com.example.main.repository.VariantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariantsService {
    @Autowired
    private VariantsRepository variantsRepository;

    public List<Variants> getAllVariants() {
        return variantsRepository.findAll();
    }

    public Variants createVariant(Variants variant) {
        return variantsRepository.save(variant);
    }

    public Optional<Variants> getVariantById(Long id) {
        return variantsRepository.findById(id);
    }

    public Variants updateVariant(Long id, Variants variant) {
        return variantsRepository.save(variant);
    }

    public void deleteVariant(Long id) {
        variantsRepository.deleteById(id);
    }
}
