/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiszbimal.institute.dao.impl;

import com.thiszbimal.institute.constant.SQLConstant;
import com.thiszbimal.institute.dao.CourseDAO;
import com.thiszbimal.institute.entity.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository(value = "CourseDAO")
public class CourseDAOImpl implements CourseDAO {
    
    @Autowired 
    private JdbcTemplate jdbcTemplate;
    
    
    @Override
    public List<Course> getAll() throws SQLException {
        return jdbcTemplate.query(SQLConstant.COURSE_GETALL, new RowMapper<Course>() {

            @Override
            public Course mapRow(ResultSet rs, int i) throws SQLException {
                
                return mapData(rs);
            }
        });
    }
    

    @Override
    public Course getById(int id) throws SQLException {
        return (Course) jdbcTemplate.queryForObject(SQLConstant.COURSE_GETById, new Object[]{id}, new RowMapper<Course>() {

            @Override
            public Course mapRow(ResultSet rs, int i) throws SQLException {
                return mapData(rs);
            }
        });
    }

    @Override
    public int insert(Course c) throws SQLException {
        return jdbcTemplate.update(SQLConstant.COURSE_INSERT, new Object[]{c.getCourseName(),c.getCourseDescription(),c.getFees(),c.getDuration(),c.getDurationType(),c.getStatus()});
    }

    @Override
    public int update(Course c) throws SQLException {
        return jdbcTemplate.update(SQLConstant.COURSE_UPDATE, new Object[]{c.getCourseName(),c.getCourseDescription(),c.getFees(),c.getDuration(),c.getDurationType(),c.getStatus(),c.getModifiedDate(),c.getId()} );
    }

    @Override
    public int delete(int id) throws SQLException {
        return jdbcTemplate.update(SQLConstant.COURSE_DELETE, new Object[]{id});
    }
    private Course mapData(ResultSet rs)throws SQLException {
        Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setCourseName(rs.getString("course_name"));
                course.setCourseDescription(rs.getString("course_description"));
                course.setFees(rs.getDouble("fees"));
                course.setDuration(rs.getInt("duration"));
                course.setDurationType(rs.getString("duration_type"));
                course.setAddedDate(rs.getDate("added_date"));
                course.setModifiedDate(rs.getDate("modified_date"));
                course.setStatus(rs.getBoolean("status"));
                return course;
    }
    
}
