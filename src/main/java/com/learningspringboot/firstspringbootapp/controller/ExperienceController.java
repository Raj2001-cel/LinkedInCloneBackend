package com.learningspringboot.firstspringbootapp.controller;

import com.learningspringboot.firstspringbootapp.entity.Experience;
import com.learningspringboot.firstspringbootapp.entity.User;
import com.learningspringboot.firstspringbootapp.model.ExperienceRequestModel;
import com.learningspringboot.firstspringbootapp.service.ExperienceService;
import com.learningspringboot.firstspringbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
