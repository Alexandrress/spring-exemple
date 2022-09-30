/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller.api;

import com.example.demo.dto.SchedulesDto;
import com.example.demo.dto.TeacherDto;
import com.example.demo.dto.TeachersDto;
import com.example.demo.service.ScheduleService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Alexa
 */

@Controller
public class TeacherApiController extends AbstractApiController {
    
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ScheduleService scheduleService;
    
    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    @ResponseBody
    public TeachersDto getTeachers() {
        return teacherService.findAll();
    }
    
    @RequestMapping(value = "/teachers/{teacherId}", method = RequestMethod.GET)
    @ResponseBody
    public TeacherDto getTeacher(@PathVariable int teacherId) {
        return teacherService.findById(teacherId);
    }
    
    @RequestMapping(value = "/teachers/{teacherId}/schedules", method = RequestMethod.GET)
    @ResponseBody
    public SchedulesDto getSchedule(@PathVariable int teacherId){
        return scheduleService.getTeacherSchedule(teacherId);
    }
}
