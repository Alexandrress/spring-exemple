/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.TeacherDto;
import com.example.demo.model.TeacherModel;
import com.example.demo.repository.TeacherRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Alexa
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TeacherService.class)
public class TeacherServiceTest {
    
    @Autowired
    private TeacherService teacherService;
    
    @MockBean
    private TeacherRepository teacherRepository;
    
    @Test
    public void shouldFindTeacherById(){
        TeacherModel fooBar = new TeacherModel(1, "Foo", "Bar", "Spring");
        Mockito.when(teacherRepository.findById(1)).thenReturn(fooBar);
        
        TeacherDto teacherDto = teacherService.findById(1);
        assertEquals("Foo", teacherDto.getFirstName());
    }
}
