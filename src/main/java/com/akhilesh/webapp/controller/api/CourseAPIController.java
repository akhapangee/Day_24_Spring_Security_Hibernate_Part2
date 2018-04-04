/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.webapp.controller.api;

import com.akhilesh.webapp.service.CourseService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Akhilesh
 */
@RestController
@RequestMapping(value="/api/courses")
public class CourseAPIController {
    
    @Autowired
    private CourseService courseService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity index(){
        return  ResponseEntity.ok(courseService.getAll());
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity getId(@PathVariable("id")int id){
        return  ResponseEntity.ok(courseService.getById(id));
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity delete(@PathVariable("id") int id){
        Map<String, Object> data = new HashMap<>();
        data.put("success", courseService.delete(id));
        return  ResponseEntity.ok(data);
    }
    
}
