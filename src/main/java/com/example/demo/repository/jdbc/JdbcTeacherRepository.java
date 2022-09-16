/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository.jdbc;

import com.example.demo.model.TeacherModel;
import com.example.demo.repository.TeacherRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexa
 */
@Repository
public class JdbcTeacherRepository implements TeacherRepository {
    private static final String FIND_ALL_QUERY = "SELECT * FROM teacher;";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM teacher WHERE id = ?;";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
            
    @Override
    public List<TeacherModel> findAll(){
        return jdbcTemplate.query(FIND_ALL_QUERY, new TeacherRowMapper());
    }

    @Override
    public TeacherModel findById(int id) {
        try{
            return jdbcTemplate.queryForObject(FIND_BY_ID_QUERY, new Object[]{id}, new TeacherRowMapper());
        }
        catch(EmptyResultDataAccessException exception){
            return null;
        }
    }
}
