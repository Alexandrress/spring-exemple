/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Alexa
 */
public class ScheduleDto {
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private String classRoom;

    public ScheduleDto() {
    }
    
    public ScheduleDto(LocalDate date, LocalTime start, LocalTime end, String classRoom) {
        this.date = date;
        this.start = start;
        this.end = end;
        this.classRoom = classRoom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}
