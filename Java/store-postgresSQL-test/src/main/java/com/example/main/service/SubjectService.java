package com.example.main.service;

import com.example.main.model.Subject;
import com.example.main.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    public Subject CreateSubject(Subject subject) {
        return subjectRepository.save(subject);
    };

    public Subject updateSubject(Subject subject) {
        return subjectRepository.save(subject);
    }
    public  Subject deleteSubject(Long id){
        Subject subject = subjectRepository.findById(id).get();
        subjectRepository.deleteById(id);
        return subject;
    }


}
