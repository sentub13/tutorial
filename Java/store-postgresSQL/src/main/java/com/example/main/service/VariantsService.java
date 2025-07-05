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

    public Optional<Variants> getVariantById(Integer id) {
        return variantsRepository.findById(id);
    }

    public Variants createVariant(Variants variant) {
        return variantsRepository.save(variant);
    }

    public void deleteVariant(Integer id) {
        variantsRepository.deleteById(id);
    }
}
