/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller.api;

import com.example.demo.dto.ScheduleDto;
import com.example.demo.dto.SchedulesDto;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Alexa
 */
@Controller
@RequestMapping("/mock")
public class ScheduleMockController {
    
    private static final Map<Integer, List<ScheduleDto>> schedules = new HashMap<Integer,List<ScheduleDto>>(){{
        put(1, Arrays.asList(
            new ScheduleDto(LocalDate.now(), LocalTime.of(8,0), LocalTime.of(10,0), "Lab"),
            new ScheduleDto(LocalDate.now(), LocalTime.of(10,0), LocalTime.of(12,0), "S001")
        ));
        put(2, Arrays.asList(
            new ScheduleDto(LocalDate.now(), LocalTime.of(8,0), LocalTime.of(12,0), "S002")
        ));
    }};
    
    @RequestMapping(value="/schedules", method = RequestMethod.GET)
    @ResponseBody
    public SchedulesDto getTeacherSchedule(@RequestParam int teacherId) throws InterruptedException{
        Thread.sleep(3000); //Simulate API response
        List<ScheduleDto> scheduleDtos = schedules.get(teacherId);
        return new SchedulesDto(scheduleDtos == null ? new ArrayList<>() : scheduleDtos);
    }
}
