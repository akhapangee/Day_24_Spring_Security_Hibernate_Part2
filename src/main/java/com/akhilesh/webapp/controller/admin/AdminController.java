package com.akhilesh.webapp.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Akhilesh
 */
@Controller
@RequestMapping(value = "/admin/courses")
public class AdminController {
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "Secured Area";
    }
    
}
