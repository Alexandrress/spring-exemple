/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.TeacherModel;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Alexa
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TeacherRepositoryTest {
    
    @Autowired
    private TeacherRepository teacherRepository;
    
    @Test
    public void shouldFindTeacherById(){
        TeacherModel foundTeacher = teacherRepository.findById(1);
        assertEquals(1, foundTeacher.getId());
    }
    
    @Test
    public void shouldReturnNullWhenTeacherIsNotFoundById(){
        assertNull(teacherRepository.findById(666));
    }
}
