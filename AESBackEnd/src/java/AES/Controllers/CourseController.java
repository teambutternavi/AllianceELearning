/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Controllers;

import AES.DAO.CourseDAO;
import AES.DAO.PresentationDAO;
import AES.Model.Course;
import AES.Model.Presentation;
import AES.Model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jon mark
 */
@RestController
@RequestMapping(value="/course",method=RequestMethod.GET)
public class CourseController {
    @RequestMapping(value="/createCourse",method=RequestMethod.GET)
    public Course createCourse(//parameter (String title,String description)
            @RequestParam Map<String,String> requestParams
    )throws IOException, SQLException, ClassNotFoundException, Exception{
         Course cs=new Course();
        cs=CourseDAO.createCourse(requestParams.get("title"),requestParams.get("description"));
        return cs;
    }
    
    
      @RequestMapping(value="/deleteCourse",method=RequestMethod.GET)
    public void deleteCourse(//parameter (String title)
            @RequestParam Map<String,String> requestParams
    )throws IOException, SQLException, ClassNotFoundException, Exception{
        CourseDAO.removeCourse(CourseDAO.getCourseByTitle(requestParams.get("title")));
    }
    
     @RequestMapping(value="/getAllCourses",method=RequestMethod.GET)
    public List<Course> getAllCourses(
    )throws IOException, SQLException, ClassNotFoundException, Exception{
        return CourseDAO.getAllCourse();
    }
    
    
      @RequestMapping(value="/getAllCourseTakenBy",method=RequestMethod.GET)
    public List<Course> getAllCoursesTakenBy(//parameter (id of trainee)
            @RequestParam Map<String,String> requestParams
    )throws IOException, SQLException, ClassNotFoundException, Exception{
        return CourseDAO.getAllCourseTakenBy(Integer.parseInt(requestParams.get("id")));
    }
    
    @RequestMapping(value="/editCourse",method=RequestMethod.GET)//parameter (int id, String title,String description)
    public void editCourse(@RequestParam Map<String,String> requestParams)throws IOException, SQLException, ClassNotFoundException, Exception
    {
        CourseDAO.updateCourse(Integer.parseInt(requestParams.get("id")),requestParams.get("title"), requestParams.get("description"));
    }
    
     @RequestMapping(value="/assignTraineeToCourse",method=RequestMethod.GET)//parameter (int id of trainee,int id of course)
    public void assignCourse(@RequestParam Map<String,String> requestParams)throws IOException, SQLException, ClassNotFoundException, Exception
    {
        CourseDAO.assignTraineeToCourse(Integer.parseInt(requestParams.get("traineeid")),Integer.parseInt(requestParams.get("courseid")));
    }
    
    
         @RequestMapping(value="/removeTraineeFromCourse",method=RequestMethod.GET)//parameter (int id of trainee,int id of course)
    public void removeTraineefromCourse(@RequestParam Map<String,String> requestParams)throws IOException, SQLException, ClassNotFoundException, Exception
    {
        CourseDAO.removeTraineeFromCourse(Integer.parseInt(requestParams.get("traineeid")),Integer.parseInt(requestParams.get("courseid")));
    }
    
             @RequestMapping(value="/getAllUserTakingCourse",method=RequestMethod.GET)//parameter (int id of trainee,int id of course)
    public List<User> getAllUsersTakingCourse(@RequestParam Map<String,String> requestParams)throws IOException, SQLException, ClassNotFoundException, Exception
    {
       return CourseDAO.getAllUsersTakingCourse(Integer.parseInt(requestParams.get("courseid")));
    }
    
 
    
    
    
    
    
    
}
    
