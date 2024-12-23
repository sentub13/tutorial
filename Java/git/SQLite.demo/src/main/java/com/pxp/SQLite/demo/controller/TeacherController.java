package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Teacher;
import com.pxp.SQLite.demo.service.TeacherService;
import com.pxp.SQLite.demo.utility.ParseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/api/teacher")
public class TeacherController {

    // Autowired dependencies
    @Autowired
    private TeacherService teacherService;  // Service layer for teacher operations

    @Autowired
    private ParseData parseData;  // Utility to convert data to JSON format (if needed)

    /**
     * Endpoint to create a new teacher.
     * @param teacher - Teacher object to be created.
     * @return ResponseEntity containing the created Teacher object.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher) {
        try {
            // Attempt to create teacher and return successful response with teacher data
            Teacher response = teacherService.create(teacher);
            System.out.println("Json---: " + parseData.getJsonData(response));
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            // If email already exists, return conflict response
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    /**
     * Endpoint to create a new teacher and return a list containing that teacher.
     * @param teacher - Teacher object to be created.
     * @return ResponseEntity containing a list with the created teacher.
     */
    @RequestMapping(value = "/createArr", method = RequestMethod.POST)
    public ResponseEntity<List<Teacher>> createTeacherArr(@RequestBody Teacher teacher) {
        Teacher response = teacherService.create(teacher);
        System.out.println("Json---: " + parseData.getJsonData(response));
        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonList(response));
    }

    /**
     * Endpoint to get all teachers from the database.
     * @return ResponseEntity containing a list of all teachers or empty list if none found.
     */
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<List<Teacher>> getAllTeacher() {
        try {
            // Retrieve all teachers
            List<Teacher> teachers = (List<Teacher>) teacherService.read();

            if (teachers != null && !teachers.isEmpty()) {
                System.out.println("Json---1: " + parseData.getJsonData(teachers));
                return ResponseEntity.status(HttpStatus.OK).body(teachers);  // Return teachers if found
            } else {
                System.out.println("Json---2: " + parseData.getJsonData(teachers));
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Collections.emptyList());  // Return empty list if no teachers
            }
        } catch (Exception e) {
            // In case of exception, return internal server error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonList(new Teacher()));  // Return empty teacher object in case of error
        }
    }

    /**
     * Endpoint to update an existing teacher.
     * @param teacher - Updated Teacher object.
     * @return ResponseEntity containing the updated Teacher object.
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
        try {
            // Update teacher and return updated teacher
            Teacher updatedTeacher = teacherService.update(teacher);
            return ResponseEntity.status(HttpStatus.OK).body(updatedTeacher);
        } catch (Exception e) {
            // If any error occurs, return internal server error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * Endpoint to update a teacher by its ID.
     * @param id - Teacher ID to be updated.
     * @param teacher - Teacher object with updated data.
     * @return ResponseEntity with success message.
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTeacherById(@PathVariable("id") int id, @RequestBody Teacher teacher) {
        teacherService.updateById(id, teacher);
        return ResponseEntity.ok("Item updated successfully");
    }

    /**
     * Endpoint to delete a teacher.
     * @param teacher - Teacher object to be deleted.
     * @return ResponseEntity containing the deleted Teacher object.
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTeacher(@RequestBody Teacher teacher) {
        try {
            // Attempt to delete teacher and return successful response
            Teacher deletedTeacher = teacherService.delete(teacher);
            return ResponseEntity.status(HttpStatus.OK).body(deletedTeacher);
        } catch (Exception e) {
            // If any error occurs, return internal server error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    /**
     * Endpoint to delete a teacher by its ID.
     * @param id - Teacher ID to be deleted.
     * @return ResponseEntity with success message.
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTeacherById(@PathVariable("id") int id) {
        teacherService.deleteById(id);
        return ResponseEntity.ok("Item deleted successfully");
    }

    /**
     * Endpoint to delete all teachers.
     * @return ResponseEntity with success message.
     */
    @RequestMapping(value = "/deleteall", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAll() {
        teacherService.deleteAll();
        return ResponseEntity.ok("Deleted all teachers");
    }
}
