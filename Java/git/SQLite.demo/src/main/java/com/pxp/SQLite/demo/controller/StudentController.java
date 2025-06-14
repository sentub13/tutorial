package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Student;
import com.pxp.SQLite.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public List<Student> readStudents(){
        return studentService.readStudents();
    }

    @RequestMapping(value = "/updates", method = RequestMethod.PUT)
    public String updateStudet(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @RequestMapping(value = "/deletes", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestBody Student student){
        return studentService.deleteStudent(student);
    }
}
