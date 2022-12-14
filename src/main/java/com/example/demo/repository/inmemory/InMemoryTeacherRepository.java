/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository.inmemory;

import com.example.demo.model.TeacherModel;
import com.example.demo.repository.TeacherRepository;
import java.util.List;
import java.util.Arrays;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexa
 */
@Repository
@ConditionalOnProperty(name = "demo.repository", havingValue = "inmemory")
public class InMemoryTeacherRepository implements TeacherRepository {

    private static final List<TeacherModel> teachers = Arrays.asList(
            new TeacherModel(1, "Alain", "Husson", "Anglais"),
            new TeacherModel(2, "Philippe", "Kubiak", "Informatique"),
            new TeacherModel(3, "Thierry", "Fricheteau", "Gestion de projet"),
            new TeacherModel(4, "Didier", "Corbel", "Informatique"),
            new TeacherModel(5, "Marcel", "Boulier", "Electricit√©")
    );
            
    @Override
    public List<TeacherModel> findAll() {
        return teachers;
    }

    @Override
    public TeacherModel findById(int id) {
        return teachers
                .stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(TeacherModel teacherModel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}