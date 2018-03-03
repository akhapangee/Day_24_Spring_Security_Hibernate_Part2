package com.akhilesh.webapp.controller;

import com.akhilesh.webapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Akhilesh
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        //what happens if we do this 
        courseService.getAll();
        courseService.getAll();
        courseService.getAll();
        model.addAttribute("courses", courseService.getAll());
        return "index";
    }

    
}
