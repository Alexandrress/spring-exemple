/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.dto.SchedulesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Alexa
 */
@Service
public class ScheduleService {
    @Autowired
    private Environment environment;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Cacheable(value = "schedules", key = "#teacherId")
    public SchedulesDto getTeacherSchedule(int teacherId){
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(environment.getProperty("webservices.schedule.url"))
                .queryParam("teacherId", Integer.toString(teacherId));
        return restTemplate.getForObject(builder.toUriString(), SchedulesDto.class);
    }
}
