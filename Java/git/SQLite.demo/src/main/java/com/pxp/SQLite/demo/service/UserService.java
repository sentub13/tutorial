package com.pxp.SQLite.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pxp.SQLite.demo.entity.Student;
import com.pxp.SQLite.demo.entity.User;
import com.pxp.SQLite.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public String createUser (User user) {
        // ObjectMapper objectMapper = new ObjectMapper();
        try {
            userRepository.save(user);
            return "User record created successfully.";
            //System.out.println("CreateUser-----" + objectMapper.writeValueAsString(user));
        } catch (Exception e) {
           //  throw new RuntimeException(e);
            throw e;
        }
    }

    @Transactional
    public List<User> readUser(){
        return userRepository.findAll();
    }

    @Transactional
    public String updateUser(User user) {

        if(userRepository.existsByEmail(user.getEmail())){
            try {
                List<User> _user = userRepository.findByEmail(user.getEmail());
                // System.out.println("_user======" + _user.stream());
                _user.stream().forEach(el -> {
                    User userToBeUpdate = userRepository.findById(el.getId()).get();
                    userToBeUpdate.setName(user.getName());
                    userToBeUpdate.setEmail(user.getEmail());
                    userToBeUpdate.setPhoneno(user.getPhoneno());
                    userToBeUpdate.setAddress(user.getAddress());
                    userToBeUpdate.setCountry(user.getCountry());
                    userToBeUpdate.setState(user.getState());
                    userToBeUpdate.setZipcode(user.getZipcode());
                });
                return "User Record updated";
            } catch (Exception e){
                throw e;
            }
        }
        return null;
    };

    @Transactional
    public String deleteUser(User user){
        if (userRepository.existsByEmail(user.getEmail())){
            try {
                List<User> _users = userRepository.findByEmail(user.getEmail());
                _users.stream().forEach(el -> {
                    // System.out.println("el======" + el);
                    userRepository.delete(el);
                });
                return "User record deleted successfully";
            } catch (Exception e){
                throw e;
            }
        }
        return null;
    }
}
