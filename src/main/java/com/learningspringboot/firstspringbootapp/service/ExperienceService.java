package com.learningspringboot.firstspringbootapp.service;

import com.learningspringboot.firstspringbootapp.entity.Experience;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ExperienceService {
    public Experience saveExperience(Experience experience);

    List<Experience> getExperiencesByUserId(long parseLong);
}
