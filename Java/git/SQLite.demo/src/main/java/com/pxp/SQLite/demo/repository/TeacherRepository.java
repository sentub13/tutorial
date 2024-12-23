package com.pxp.SQLite.demo.repository;

import com.pxp.SQLite.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    public boolean existsByEmail(String teacher);
}
