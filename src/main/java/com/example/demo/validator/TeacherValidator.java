package com.example.demo.validator;

import com.example.demo.dto.TeacherDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alexa
 */
@Component
public class TeacherValidator implements Validator {
    
    public static final String FIELD_IS_REQUIRED = "Field is required !";
    
    @Override
    public boolean supports(Class<?> aClass)
    {
        return TeacherDto.class.equals(aClass);
    }
    
    @Override
    public void validate(Object o, Errors errors){
        TeacherDto teacher = (TeacherDto) o;
        ValidationUtils.rejectIfEmpty(errors, "firstName", FIELD_IS_REQUIRED);
        ValidationUtils.rejectIfEmpty(errors, "lastName", FIELD_IS_REQUIRED);
        ValidationUtils.rejectIfEmpty(errors, "subject", FIELD_IS_REQUIRED);
    }
}
