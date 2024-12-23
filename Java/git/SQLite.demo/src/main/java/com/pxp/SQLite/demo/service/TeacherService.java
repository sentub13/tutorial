package com.pxp.SQLite.demo.service;

import com.pxp.SQLite.demo.entity.Teacher;
import com.pxp.SQLite.demo.repository.TeacherRepository;
import com.pxp.SQLite.demo.utility.ParseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    // Autowired dependencies
    @Autowired
    private TeacherRepository teacherRepository;  // Repository to interact with the database

    @Autowired
    private ParseData parseData;  // Utility for JSON parsing (if needed)

    /**
     * Method to create a new teacher record (Employee).
     * @param teacher - Teacher object containing teacher data to be saved.
     * @return String indicating success or failure of the creation.
     */
    @Transactional
    public String createEmp(Teacher teacher) {
        try {
            teacherRepository.save(teacher);  // Save teacher to the database
            return "Employee record created successfully.";
        } catch (Exception e) {
            throw e;  // Re-throw any exception that occurs during the save
        }
    }

    /**
     * Method to create a new teacher and handle email duplication check.
     * @param teacher - Teacher object to be created.
     * @return Created Teacher object.
     */
    @Transactional
    public Teacher create(Teacher teacher) {
        // Check if email already exists
        if (teacherRepository.existsByEmail(teacher.getEmail())) {
            throw new IllegalArgumentException("Email id is already exist;");
        }
        // Save the teacher if email doesn't exist
        Teacher createResponse = teacherRepository.save(teacher);
        System.out.println("Service - create: " + parseData.getJsonData(createResponse));
        return createResponse;
    }

    /**
     * Method to get all teachers from the database.
     * @return List of all teachers.
     */
    @Transactional
    public List<Teacher> read() {
        List<Teacher> readResponse = teacherRepository.findAll();  // Fetch all teachers
        return readResponse;
    }

    /**
     * Method to get a teacher by its ID.
     * @param id - ID of the teacher to be fetched.
     * @return Teacher object corresponding to the given ID.
     */
    @Transactional
    public Teacher readById(int id) {
        // Find teacher by ID, throw exception if not found
        Optional<Teacher> response = teacherRepository.findById(id);
        return response.orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    /**
     * Method to update the details of an existing teacher.
     * @param teacher - Teacher object containing updated data.
     * @return Updated Teacher object.
     */
    @Transactional
    public Teacher update(Teacher teacher) {
        Teacher updateResponse = teacherRepository.save(teacher);  // Save the updated teacher details
        return updateResponse;
    }

    /**
     * Method to update teacher details by ID.
     * @param id - Teacher ID for the teacher to be updated.
     * @param teacher - Teacher object containing updated data.
     * @return String indicating the update was successful.
     */
    @Transactional
    public String updateById(int id, Teacher teacher) {
        // Find teacher by ID, throw exception if not found
        Teacher existingTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher didn't found"));

        // Update teacher details
        existingTeacher.setName(teacher.getName());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setPhoneno(teacher.getPhoneno());
        existingTeacher.setAddress(teacher.getAddress());

        return "Teacher updated successfully.";
    }

    /**
     * Method to delete a teacher by the Teacher object.
     * @param teacher - Teacher object to be deleted.
     * @return Deleted Teacher object.
     */
    @Transactional
    public Teacher delete(Teacher teacher) {
        teacherRepository.delete(teacher);  // Delete the teacher from the database
        return teacher;  // Return the deleted teacher
    }

    /**
     * Method to delete a teacher by its ID.
     * @param id - ID of the teacher to be deleted.
     * @return String indicating the deletion was successful.
     */
    @Transactional
    public String deleteById(int id) {
        teacherRepository.deleteById(id);  // Delete the teacher by ID
        return "Deleted item";  // Return success message
    }

    /**
     * Method to delete all teachers from the database.
     * @return String indicating all teachers were deleted successfully.
     */
    @Transactional
    public String deleteAll() {
        teacherRepository.deleteAll();  // Delete all teachers
        return "All teachers deleted successfully";
    }
}
