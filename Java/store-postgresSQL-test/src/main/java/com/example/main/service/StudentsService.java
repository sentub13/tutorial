package com.example.main.service;

import com.example.main.model.Students;
import com.example.main.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }

    public Optional<Students> getStudentById(Long id){
        return studentsRepository.findById(id);
    }

    public Students saveStudent(Students students) {
        return studentsRepository.save(students);
    }

    public Students updateStudent(Students students) {
        return studentsRepository.save(students);
    }

    public void deleteStudent(Students students) {
        studentsRepository.delete(students);
    }

    public void deleteStudentById(Long id) {
        studentsRepository.deleteById(id);
    }


}
