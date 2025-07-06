package com.example.main.repository;

import com.example.main.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // Optionally add custom query methods here
}

