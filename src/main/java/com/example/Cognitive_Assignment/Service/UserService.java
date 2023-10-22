package com.example.Cognitive_Assignment.Service;

import com.example.Cognitive_Assignment.Model.UserDetails;
import com.example.Cognitive_Assignment.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepo iUserRepo;

    public ResponseEntity<String> createUser(UserDetails userDetails) {
        iUserRepo.save(userDetails);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }


    public Optional<UserDetails> getUserDetails(int id) {
        Optional<UserDetails> userDetails= Optional.of(iUserRepo.findById(id).get());
        return userDetails;
    }

    public String updateUserDetails(UserDetails userDetails, int id) {
        UserDetails userDetails1 = iUserRepo.findById(id).get();
        userDetails1.setFirstName(userDetails.getFirstName());
        userDetails1.setEmail(userDetails.getEmail());
        userDetails1.setMobileNumber(userDetails.getMobileNumber());
        iUserRepo.save(userDetails1);
        return "userDetails "+id+" updated";
    }

    public String deleteUserDetails(int id) {
        iUserRepo.deleteById(id);
        return "User id "+id+" deleted";
    }
}
