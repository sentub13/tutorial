package com.example.main.repository;

import com.example.main.model.Variants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantsRepository extends JpaRepository<Variants, Long> {
}

