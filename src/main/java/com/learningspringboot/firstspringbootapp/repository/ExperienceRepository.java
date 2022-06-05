package com.learningspringboot.firstspringbootapp.repository;

import com.learningspringboot.firstspringbootapp.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Long> {

    List<Experience> findAllByUserId(long parseLong);
}
