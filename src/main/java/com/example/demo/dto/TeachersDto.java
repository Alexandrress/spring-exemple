/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import java.util.List;

/**
 *
 * @author Alexa
 */
public class TeachersDto {
    private List<TeacherDto> teachers;

    public TeachersDto(List<TeacherDto> teachers) {
        this.teachers = teachers;
    }

    public List<TeacherDto> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherDto> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "TeachersDto{" + "teachers=" + teachers + '}';
    }
}
