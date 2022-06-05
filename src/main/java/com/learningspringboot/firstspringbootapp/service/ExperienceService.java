package com.learningspringboot.firstspringbootapp.service;

import com.learningspringboot.firstspringbootapp.entity.Experience;
import org.springframework.stereotype.Service;


@Service
public interface ExperienceService {
    public Experience saveExperience(Experience experience);
}
