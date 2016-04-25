/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiszbimal.institute.constant;

/**
 *
 * @author admin
 */
public class SQLConstant {
    public final static String COURSE_GETALL= "select * from "+TableConstant.TBL_COURSE;
    public final static String COURSE_INSERT= "insert into "+TableConstant.TBL_COURSE+ 
            " (course_name, course_description, fees, duration, duration_type, status) values(?,?,?,?,?,?)";
    public final static String COURSE_GETById="select * from " + TableConstant.TBL_COURSE + " where id=?";
    public final static String COURSE_UPDATE ="UPDATE " + TableConstant.TBL_COURSE 
                                             + " SET course_name=?,course_description=?,fees=?,duration=?,duration_type=?,status=?,modified_date=? WHERE id=?";
    public final static String COURSE_DELETE="delete from " + TableConstant.TBL_COURSE + " WHERE id=?";


}   
