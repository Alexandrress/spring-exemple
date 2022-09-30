/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.TeacherModel;
import java.util.List;

/**
 *
 * @author Alexa
 */
public interface TeacherRepository {
    
    List<TeacherModel> findAll();
    TeacherModel findById(int id);
    void save(TeacherModel teacherModel);
}
