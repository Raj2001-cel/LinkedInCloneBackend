package com.learningspringboot.firstspringbootapp.service;

import com.learningspringboot.firstspringbootapp.entity.Experience;
import com.learningspringboot.firstspringbootapp.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    @Override
    public Experience saveExperience(Experience experience) {
        return experienceRepository.save(experience);
    }
}