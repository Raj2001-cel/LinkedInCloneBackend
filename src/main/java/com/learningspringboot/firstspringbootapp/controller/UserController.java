package com.learningspringboot.firstspringbootapp.controller;

import com.learningspringboot.firstspringbootapp.entity.*;
import com.learningspringboot.firstspringbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody User user){
        //check if the user already exists
        List<User>  allusers =  getAllUser();
        boolean isAccountExist = checkAccountExistence(user,allusers);
        if(isAccountExist){
           return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of(
                    "error", true,
                    "message", "account already exist"));
        }

        User savedUser = userServiceImpl.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "user",savedUser
        ));
    }

    @GetMapping("/allUser")
    public List<User> getAllUser(){
        return userServiceImpl.getAllUser();
    }


    public boolean checkAccountExistence(User user,List<User> allUsers){
        for(User eachUser:allUsers){
            if(eachUser.getUser_name().equals(user.getUser_name()))return true;
        }
        return  false;
    }

    @GetMapping(path="/getuserbyid/{userId}")
    public User getUserById(@PathVariable String userId){
        Long userid = Long.parseLong(userId);
        return  userServiceImpl.getUserById(userid);
    }
}
