/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller.api;
import java.text.MessageFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Alexa
 */
@Controller
public class VersionController extends AbstractApiController {
    @Autowired
    private Environment env;
    
    @RequestMapping(value = "/version", method = RequestMethod.GET)
    @ResponseBody
    public String version() {
       String version = env.getProperty("application.version", "undefined");
       return MessageFormat.format("Version {0} - Demo Application", version);
    }
}
