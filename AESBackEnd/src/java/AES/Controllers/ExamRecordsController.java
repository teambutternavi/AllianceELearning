package AES.Controllers;

import AES.DAO.ExamDAO;
import AES.DAO.ExamRecordsDAO;
import AES.Model.Exam;
import AES.Model.Examrecords;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asi
 */
@RestController
@RequestMapping(value="/examRecords",method=RequestMethod.POST)
public class ExamRecordsController {
    
    @RequestMapping(value="/addExamRecord", method=RequestMethod.GET)
    public boolean addExamRecord(@RequestParam Map<String, String> requestParams){
    return ExamRecordsDAO.addExamRecord(Integer.parseInt(requestParams.get("examid")), Integer.parseInt(requestParams.get("userid")), Integer.parseInt(requestParams.get("score")),Date.valueOf(requestParams.get("date")));
    }
    @RequestMapping(value="/removeExamRecord", method=RequestMethod.GET)
    public boolean removeExamRecord(@RequestParam Map<String, String> requestParams) throws IOException, ClassNotFoundException, SQLException{
    return ExamRecordsDAO.removeExamRecord(Integer.parseInt(requestParams.get("id")));
    }
    @RequestMapping(value="/getAllExamRecords", method=RequestMethod.GET)
    public List<Examrecords> getAllExamRecords(){
    return ExamRecordsDAO.getAllExamRecords();
    }
    @RequestMapping(value="/getExamRecordById", method=RequestMethod.GET)
    public Examrecords getExamRecordById(@RequestParam Map<String, String> requestParams){
    return ExamRecordsDAO.getExamRecordById(Integer.parseInt(requestParams.get("id")));
    }
    @RequestMapping(value="/exists", method=RequestMethod.GET)
    public boolean exists(@RequestParam Map<String, String> requestParams) throws IOException, ClassNotFoundException, SQLException{
    return ExamRecordsDAO.exists(Integer.parseInt(requestParams.get("id")));
    }
   
  
}
