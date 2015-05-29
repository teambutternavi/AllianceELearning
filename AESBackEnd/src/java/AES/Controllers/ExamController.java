/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Controllers;

import AES.DAO.ExamDAO;
import AES.Model.Exam;
import AES.Model.Question;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

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
    
    private Exam loadExamFile(Exam exam){
        try {
            Exam temp = Exam.generateExam(exam.getFilepath());
            for(Question q:temp.getQuestion())
                exam.addQuestion(q);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
        return exam;
    }
    @RequestMapping(value="/getExamById",method= RequestMethod.GET)
    public  Exam getExamById(@RequestParam Map<String, String> requestParams){
        Exam exam = ExamDAO.getExamById(Integer.parseInt(requestParams.get("id")));
        if(exam!=null)
            exam = loadExamFile(exam);
       return exam;
    }
    @RequestMapping(value="/getExamByTitle",method= RequestMethod.GET)
    public  Exam getExamByTitle(@RequestParam Map<String, String> requestParams){
    return ExamDAO.getExamByTitle(requestParams.get("title"));
    }
    @RequestMapping(value="/removeExam", method=RequestMethod.GET)
    public boolean removeExam(@RequestParam Map<String, String> requestParams){
    return ExamDAO.removeExam(requestParams.get("title"));
    } 
    
    
    @RequestMapping(value="/addExam", method=RequestMethod.POST)
    public boolean addExam(
            @RequestBody Exam exam,
            HttpSession session
            ){
        if(session!=null)
            Exam.examFolder = session.getServletContext().getRealPath("")+Exam.examFolder;
        boolean ok = false;
        if(ExamDAO.exists(exam.getTitle())==false){
            try {
                exam.setFilepath(exam.generateXMLToDefaultPath(exam.getTitle()));
                ExamDAO.addExam(exam);
            } catch (ParserConfigurationException | TransformerException | IOException ex1) {
                ex1.printStackTrace();
            }
        }
        return ok;
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
