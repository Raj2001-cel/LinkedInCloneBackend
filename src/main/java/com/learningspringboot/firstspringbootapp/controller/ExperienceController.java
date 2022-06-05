package com.learningspringboot.firstspringbootapp.controller;

import com.learningspringboot.firstspringbootapp.entity.Experience;
import com.learningspringboot.firstspringbootapp.entity.User;
import com.learningspringboot.firstspringbootapp.model.ExperienceRequestModel;
import com.learningspringboot.firstspringbootapp.service.ExperienceService;
import com.learningspringboot.firstspringbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @Autowired
    UserService  userService;


    @PostMapping(path = "/saveexperience/{userId}")
    public Experience saveExperience(@RequestBody ExperienceRequestModel experienceRequestModel, @PathVariable String userId){
        User user =  userService.getUserById(Long.parseLong(userId));

        Experience experience =
                new Experience(experienceRequestModel.getCompanyName(),experienceRequestModel.getJobRole(),experienceRequestModel.getStartDate(),experienceRequestModel.getEndDate(),experienceRequestModel.getJobDescription(),experienceRequestModel.getMediaUrl(),experienceRequestModel.isPresent(),user);
        return experienceService.saveExperience(experience);
    }


    @GetMapping(path = "/getexperiences/{userId}")
    public ResponseEntity<Map<String, List<Experience>>> getExperiencesByUserId(@PathVariable String userId){
        List<Experience> experiences =  experienceService.getExperiencesByUserId(Long.parseLong(userId));

        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "experiences",experiences
        ));
    }
}
