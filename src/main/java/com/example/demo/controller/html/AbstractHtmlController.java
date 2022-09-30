/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller.html;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Alexa
 */
public abstract class AbstractHtmlController {
    
    @Autowired
    private Environment env;
    
    @ModelAttribute
    public void commonAttributes(Model model){
        model.addAttribute("version", env.getProperty("application.version", "undefined"));
    }
}
