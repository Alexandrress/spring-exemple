/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.TeacherDto;
import com.example.demo.dto.TeachersDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.TeacherModel;
import com.example.demo.repository.TeacherRepository;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexa
 */
@Service
public class TeacherService {
    
    @Autowired
    // @Qualifier("jdbcTeacherRepository") Remplacé dans RepositoryConfiguration puis dans app.properties
    private TeacherRepository teacherRepository;
    
    public TeachersDto findAll(){
        List<TeacherDto> teachers = teacherRepository
                .findAll()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
        return new TeachersDto(teachers);
    }
    
    public TeacherDto findById(int id){
        TeacherModel teacherModel = teacherRepository.findById(id);
        if(teacherModel != null){
            return convert(teacherModel);
        }
        throw new EntityNotFoundException(
            MessageFormat.format("Following teacher has not been found : {0}", teacherModel)
        );
    }
    
    private TeacherDto convert(TeacherModel teacherModel){
        return new TeacherDto(teacherModel.getId(), teacherModel.getFirstName(), teacherModel.getLastName(), teacherModel.getSubject());
    }
}
