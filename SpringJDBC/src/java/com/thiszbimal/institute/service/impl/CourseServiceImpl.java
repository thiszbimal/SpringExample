/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiszbimal.institute.service.impl;

import com.thiszbimal.institute.dao.CourseDAO;
import com.thiszbimal.institute.entity.Course;
import com.thiszbimal.institute.service.CourseService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service(value = "CourseService")
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseDAO courseDAO;
    @Override
    public List<Course> getAll() throws SQLException {
        return courseDAO.getAll();
    }

    @Override
    public Course getById(int id) throws SQLException {
        return courseDAO.getById(id);
    }

    @Override
    public int insert(Course c) throws SQLException {
        return courseDAO.insert(c);
    }

    @Override
    public int update(Course c) throws SQLException {
        return courseDAO.update(c);
    }

    @Override
    public int delete(int id) throws SQLException {
        return courseDAO.delete(id);
    }
    
}
