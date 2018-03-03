package com.akhilesh.webapp.service;

import com.akhilesh.webapp.dao.CourseDAO;
import com.akhilesh.webapp.entity.Course;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Akhilesh
 */
@Service(value = "courseService")
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseDAO courseDAO;
    
    private List<Course> courseList= null;

    @Override
    public int insert(Course t) {
        return courseDAO.insert(t);
    }

    @Override
    public void update(Course t) {
        courseDAO.update(t);
    }

    @Override
    public boolean delete(int id) {
        return courseDAO.delete(id);
    }

    @Override
    public Course getById(int id) {
        return courseDAO.getById(id);
    }

    @Override
    public List<Course> getAll() {
        if(courseList == null){
            System.out.println("Course cached");
            courseList = courseDAO.getAll();
        }
        return courseList;
    }
    
}
