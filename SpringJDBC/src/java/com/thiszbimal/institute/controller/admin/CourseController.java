/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiszbimal.institute.controller.admin;

////import com.thiszbimal.institute.entity.Course;
import com.thiszbimal.institute.entity.Course;
import com.thiszbimal.institute.service.CourseService;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping(value = "/admin/courses")
public class CourseController {
    @Autowired
    
    private CourseService courseService;
    
    @RequestMapping(method = RequestMethod.GET)
    public  String Index(ModelMap mp)throws SQLException{
        mp.addAttribute("courses", courseService.getAll());
        return "admin/courses/index";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public  ModelAndView add() throws SQLException{
        ModelAndView mv= new ModelAndView("admin/courses/add");
        Course course = new Course();
        mv.addObject("Course", course);
        return mv;
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public  ModelAndView edit(@PathVariable("id") int id) throws SQLException{
        ModelAndView mv= new ModelAndView("admin/courses/edit");
        
        mv.addObject("Course", courseService.getById(id));
        return mv;
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public  String delete(@PathVariable("id") int id) throws SQLException{
        courseService.delete(id);
        
        return "redirect:/admin/courses";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    
    public String save(@ModelAttribute("Course") Course c){
       if(c.getId()==0){
           try {
               courseService.insert(c);
           } catch (SQLException ex) {
               Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
           else
           try {
               c.setModifiedDate(Calendar.getInstance().getTime());
               courseService.update(c);
       } catch (SQLException ex) {
           Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
       }
       return "redirect:/admin/courses";
    }
    
    
}
//        String content="";
//        try{
//            for(Course c:courseService.getAll()){
//                content+=c.toString() +"</br>";
//                
//            }
//        return content;
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return "error";
//    }
//    @RequestMapping(value = "/getone")
//    public @ResponseBody String getOne(){
//        try{
//        return courseService.getById(5).toString();
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return "error";
//    }
//    @RequestMapping(value="/insert")
//    @ResponseBody
//    public String insert() throws SQLException{
//        Course c=new Course(7, "Android fgfdgfdg", "dfgdg Development", 19000, 10, "Week", true);
//        courseService.insert(c);
//        return courseService.getById(7).toString();
//        
//    }
//    @RequestMapping(value="/update")
//    @ResponseBody
//    public String update() throws SQLException{
//        Course c=new Course(5, ".NET", "dot net", 19500, 2, "Month", true);
//        c.setModifiedDate(Calendar.getInstance().getTime());
//        courseService.update(c);
//        return courseService.getById(5).toString();
//        
//    }
//    @RequestMapping(value="/delete")
//    @ResponseBody
//    public String delete() throws SQLException{
//        
//        courseService.delete(8);
//        courseService.delete(9);
//        courseService.delete(10);
//        courseService.delete(11);
//        courseService.delete(12);
//        courseService.delete(13);
//        return "successfully deleted ";
//        
//    }

