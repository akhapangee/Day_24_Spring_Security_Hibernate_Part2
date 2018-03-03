package com.akhilesh.webapp.controller.admin;

import com.akhilesh.webapp.data.ResponseData;
import com.akhilesh.webapp.entity.Course;
import com.akhilesh.webapp.service.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "/admin/course/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Course course(@PathVariable("id") int id) {
        return courseService.getById(id);
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData courses() {
        ResponseData<Course> data = new ResponseData<>();
        data.setData(courseService.getAll());
        return data;
    }

}
