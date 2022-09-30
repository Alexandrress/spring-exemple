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
public class SchedulesDto {
    private List<ScheduleDto> schedules;

    public SchedulesDto() {
    }
    
    public SchedulesDto(List<ScheduleDto> schedules){
        this.schedules = schedules;
    }

    public List<ScheduleDto> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleDto> schedules) {
        this.schedules = schedules;
    }
}
