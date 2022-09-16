/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller.api;

import com.example.demo.dto.ErrorDto;
import com.example.demo.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 *
 * @author Alexa
 */
@ControllerAdvice("com.example.demo.controller.api")
public class ExceptionApiTranslator {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionApiTranslator.class);
    
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Teacher not found")
    @ResponseBody
    public ErrorDto handleNotFoundException(Exception exception){
        logger.error("Teacher not found", exception);
        return new ErrorDto(exception.getMessage());
    }
}
