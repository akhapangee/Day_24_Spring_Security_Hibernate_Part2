package com.akhilesh.webapp.dao.impl;

import com.akhilesh.webapp.dao.CourseDAO;
import com.akhilesh.webapp.entity.Course;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Akhilesh
 */
@Repository(value="courseDAO")
public class CourseDAOImpl extends GenericDAOImpl<Course> implements CourseDAO{
    
}
