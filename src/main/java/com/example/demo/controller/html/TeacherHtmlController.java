/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller.html;

import com.example.demo.validator.TeacherValidator;
import com.example.demo.dto.TeacherDto;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Alexa
 */
@Controller
public class TeacherHtmlController extends AbstractHtmlController {
    
    @Autowired
    private TeacherValidator teacherValidator;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(teacherValidator);
    }
    
    @Autowired
    private TeacherService teacherService;
    
    @RequestMapping("/teachers")
    public String teachers(Model model){
        model.addAttribute("teachers", teacherService.findAll().getTeachers());
        return "teachers"; //Nom du fichier HTML
    }
    
    @RequestMapping("/teachers/create")
    public String initCreateTeacher(Model model){
        if(!model.containsAttribute("teacher")){
            model.addAttribute("teacher", new TeacherDto());
        }
        model.addAttribute("action", "create");
        return "teacher-create-update"; //Nom du fichier HTML
    }
    
    @PostMapping("/teachers/create")
    public String createTeacher(@Valid TeacherDto teacher, BindingResult result, RedirectAttributes attributes)
    {
        if(result.hasErrors()){
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.teacher", result);
            attributes.addFlashAttribute("teacher", teacher);
            return "redirect:/teachers/create";
        }
        teacherService.save(teacher);
        return "redirect:/teachers";
    }
    
    @RequestMapping("/teachers/{teacherId}")
    public String teachers(Model model, @PathVariable int teacherId){
        if(!model.containsAttribute("teacher")){
            model.addAttribute("teacher", teacherService.findById(teacherId));   
        }
        model.addAttribute("action", "update");
        return "teacher-create-update";
    }
    
    @PostMapping("/teachers/{teacherId}")
    public String updateTeacher(@PathVariable int teacherId, @Valid TeacherDto teacher, BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors()){
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.teacher", result);
            attributes.addFlashAttribute("teacher", teacher);
            return "redirect:/teachers/" + teacherId;
        }
        teacherService.save(teacher);
        return "redirect:/teachers";
    }    
}
