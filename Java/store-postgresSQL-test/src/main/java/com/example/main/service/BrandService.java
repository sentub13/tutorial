package com.example.main.service;

import com.example.main.model.Brand;
import com.example.main.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Optional<Brand> getBrandById(Integer id) {
        return brandRepository.findById(id);
    }

    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand updateBrand(Integer id, Brand brandDetails) {
        return brandRepository.findById(id).map(brand -> {
            brand.setName(brandDetails.getName());
            return brandRepository.save(brand);
        }).orElse(null);
    }

    public void deleteBrand(Integer id) {
        brandRepository.deleteById(id);
    }
}

