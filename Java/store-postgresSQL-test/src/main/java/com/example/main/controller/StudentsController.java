package com.example.main.controller;

import com.example.main.model.Students;
import com.example.main.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @GetMapping
    public List<Students> getAllStudents() {
        return studentsService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Students> getStudentById(@PathVariable Long id) {
        return studentsService.getStudentById(id);
    }

    @PostMapping
    public Students createStudent(@RequestBody Students student) {
        return studentsService.saveStudent(student);
    }

}
