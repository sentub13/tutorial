package com.example.main.repository;

import com.example.main.model.Variants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantsRepository extends JpaRepository<Variants, Integer> {
}
