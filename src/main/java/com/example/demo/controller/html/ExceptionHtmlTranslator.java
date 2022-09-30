package com.example.demo.controller.html;

import com.example.demo.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
 *
 * @author Alexa
 */
@ControllerAdvice("com.example.demo.controller.html")
public class ExceptionHtmlTranslator {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHtmlTranslator.class);
    
    @ExceptionHandler(EntityNotFoundException.class)
    public String handleNotFoundException(RedirectAttributes attributes, Exception exception){
        logger.error("Teacher not found : {}", exception.getMessage());
        attributes.addFlashAttribute("errorMessage", exception.getMessage());
        return "redirect:/teachers";
    }
}
