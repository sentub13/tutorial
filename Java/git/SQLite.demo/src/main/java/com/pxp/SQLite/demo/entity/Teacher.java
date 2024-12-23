package com.pxp.SQLite.demo.entity;

import javax.persistence.*;

/**
 * Entity class representing the "teacher" table in the database.
 * This class is mapped to the "teacher" table in the SQLite database.
 */
@Entity
@Table(name = "teacher")
public class Teacher {

    // The primary key for the teacher entity.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;  // Unique identifier for each teacher.

    // Teacher's name.
    private String name;

    // Teacher's email address.
    private String email;

    // Teacher's phone number.
    private String phoneno;

    // Teacher's address.
    private String address;

    /**
     * Default constructor for the Teacher entity.
     * This is required by JPA for entity instantiation.
     */
    public Teacher() {}

    /**
     * Parameterized constructor to create a Teacher object with specific values.
     *
     * @param name     The name of the teacher.
     * @param email    The email address of the teacher.
     * @param phoneno  The phone number of the teacher.
     * @param address  The address of the teacher.
     */
    public Teacher(String name, String email, String phoneno, String address) {
        this.name = name;
        this.email = email;
        this.phoneno = phoneno;
        this.address = address;
    }

    /**
     * Gets the teacher's ID.
     *
     * @return The unique ID of the teacher.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the teacher's ID.
     *
     * @param id The unique ID of the teacher.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the teacher.
     *
     * @return The name of the teacher.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the teacher.
     *
     * @param name The name of the teacher.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email address of the teacher.
     *
     * @return The email address of the teacher.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the teacher.
     *
     * @param email The email address of the teacher.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number of the teacher.
     *
     * @return The phone number of the teacher.
     */
    public String getPhoneno() {
        return phoneno;
    }

    /**
     * Sets the phone number of the teacher.
     *
     * @param phoneno The phone number of the teacher.
     */
    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    /**
     * Gets the address of the teacher.
     *
     * @return The address of the teacher.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the teacher.
     *
     * @param address The address of the teacher.
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
