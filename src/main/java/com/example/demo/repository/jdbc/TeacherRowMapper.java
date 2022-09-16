/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository.jdbc;

import com.example.demo.model.TeacherModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Alexa
 */
public class TeacherRowMapper implements RowMapper<TeacherModel> {
    @Override
    public TeacherModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setId(resultSet.getInt("id"));
        teacherModel.setFirstName(resultSet.getString("first_name"));
        teacherModel.setLastName(resultSet.getString("last_name"));
        teacherModel.setSubject(resultSet.getString("subject"));
        return teacherModel;
    }
}
