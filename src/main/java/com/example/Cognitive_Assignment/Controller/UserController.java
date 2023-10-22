package com.example.Cognitive_Assignment.Controller;

import com.example.Cognitive_Assignment.Model.UserDetails;
import com.example.Cognitive_Assignment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> createEmployee(@RequestBody UserDetails userDetails){
        return userService.createUser(userDetails);
    }

    @GetMapping("/user/{id}")
    public Optional<UserDetails> getData(@PathVariable int id){
        return userService.getUserDetails(id);
    }

    @PutMapping("/user/{id}")
    public String updateData(@RequestBody UserDetails userDetails,@PathVariable int id){
        return userService.updateUserDetails(userDetails,id);
    }

    @DeleteMapping("user/{id}")
    public String deleteData(@PathVariable int id){
        return userService.deleteUserDetails(id);
    }



}
