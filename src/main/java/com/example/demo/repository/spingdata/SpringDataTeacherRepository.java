/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository.spingdata;

import com.example.demo.model.TeacherModel;
import com.example.demo.repository.TeacherRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Alexa
 */
@org.springframework.stereotype.Repository
@ConditionalOnProperty(name = "demo.repository", havingValue = "springdata")
public interface SpringDataTeacherRepository extends TeacherRepository, Repository<TeacherModel, Integer> {
    
}
