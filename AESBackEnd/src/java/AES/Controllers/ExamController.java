/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Controllers;

import AES.DAO.ExamDAO;
import AES.Model.Exam;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asi
 */
@RestController
@RequestMapping(value="/exam",method=RequestMethod.POST)
public class ExamController {
    
    @RequestMapping(value="/getAllExam", method = RequestMethod.GET)
    public  List<Exam> getAllExam(){
    return ExamDAO.getAllExam();
    }
    @RequestMapping(value="/getExamById",method= RequestMethod.GET)
    public  Exam getExamById(@RequestParam Map<String, String> requestParams){
    return ExamDAO.getExamById(Integer.parseInt(requestParams.get("id")));
    }
    @RequestMapping(value="/getExamByTitle",method= RequestMethod.GET)
    public  Exam getExamByTitle(@RequestParam Map<String, String> requestParams){
    return ExamDAO.getExamByTitle(requestParams.get("title"));
    }
    @RequestMapping(value="/removeExam", method=RequestMethod.GET)
    public boolean removeExam(@RequestParam Map<String, String> requestParams){
    return ExamDAO.removeExam(requestParams.get("title"));
    } 
    @RequestMapping(value="/addExam", method=RequestMethod.GET)
    public boolean addExam(@RequestParam Map<String, String> requestParams){
    return ExamDAO.addExam(requestParams.get("title"), requestParams.get("description"), requestParams.get("filepath"),Integer.parseInt(requestParams.get("score")),Integer.parseInt(requestParams.get("creatorid")));
    }
    @RequestMapping(value="/editExam", method=RequestMethod.GET)
    public boolean editExam(@RequestParam Map<String, String> requestParams){
    return ExamDAO.editExam(requestParams.get("title"), requestParams.get("description"), requestParams.get("filepath"),Integer.parseInt(requestParams.get("score")),Integer.parseInt(requestParams.get("creatorid")));
    } 
    
    @RequestMapping(value="/exists", method=RequestMethod.GET)
    public boolean exists(@RequestParam Map<String, String> requestParams){
    return ExamDAO.exists(requestParams.get("title"));
    }
   
}
