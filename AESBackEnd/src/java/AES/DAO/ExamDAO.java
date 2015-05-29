/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.DAO;

import static AES.DAO.UserDAO.editUser;
import static AES.DAO.UserDAO.exists;
import static AES.DAO.UserDAO.getUserByID;
import AES.Model.Exam;
import AES.Model.User;
import AES.Model.XMLOperations;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 *
 * @author asi
 */
public class ExamDAO {
      public static boolean addExam(String title,String description, String filepath, int creatorid, int score){
        boolean ok = false;
        if(!exists(title)){
        try{
        String sql = "Insert into exam (title, description, filepath, creatorid, score) values(?,?,?,?,?)";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setString(1, title);
        ps.setString(2,  description);
        ps.setString(3,filepath);
        ps.setInt(4, creatorid);
        ps.setInt(5, score);
        ps.execute();
        ok=true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        else{System.out.println("User exists");}
        return ok;
    }
   
   public static Exam getExamByTitle(String title){
        Exam temp = null;
        try{
        String sql = "Select * from exam where title=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setString(1, title);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
           temp = new Exam();
           temp.setId(rs.getInt("id"));
           temp.setCreatorid(rs.getInt("creatorid"));
           temp.setDescription(rs.getString("description"));
           temp.setFilepath(rs.getString("filepath"));
           temp.setTitle(rs.getString("title"));
           temp.setScore(rs.getInt("score"));
            
        }
        }catch( Exception e){
            e.printStackTrace();
        }
        return temp;
    }
   public static Exam getExamById(int id){
        Exam temp = null;
        try{
        String sql = "Select * from exam where id=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
           temp = new Exam();
           temp.setId(rs.getInt("id"));
           temp.setCreatorid(rs.getInt("creatorid"));
           temp.setDescription(rs.getString("description"));
           temp.setFilepath(rs.getString("filepath"));
           temp.setTitle(rs.getString("title"));
           temp.setScore(rs.getInt("score"));
            
        }
        }catch( Exception e){
            e.printStackTrace();
        }
        return temp;
    }
   
  
    public static boolean exists(String title){
        boolean ok= false;
        if(getExamByTitle(title)!=null){
            ok=true;
        }
        return ok;
    }
    public static boolean exists(Exam exam){
        return exists(exam.getTitle());
    }
    
  
     public static boolean editExam( String title, String description, String filepath ,  int score, int creatorid){
     boolean ok = false;
     if(exists(title)){
     try{
        String sql="Update exam set description=?,filepath=?,creatorid=?,score=? where title = ?";
        PreparedStatement ps =  DatabaseManager.getInstance().getStatement(sql);
        ps.setString(1, description);
        ps.setString(2, filepath);
        ps.setInt(3, creatorid);
        ps.setInt(4, score);
        ps.setString(5, title);
        ps.execute();
        ok=true;
       }
     catch(Exception e){
            e.printStackTrace();
        }
     }
     return ok;
     }
     
    public static boolean removeExam(String title){
      boolean ok = false;
      if(exists(title)){
        try{
        String sql = "Delete from exam where title=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setString(1, title);
        ps.execute();
        ok=true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
      }
      return ok;
    }
    
    public static List<Exam> getAllExam(){
        List<Exam> temp  = new ArrayList<>();
        try
        {
            String sql = "Select * from exam";
            PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                temp.add(getExamByTitle(rs.getString("title")));
            }
          
        }
        catch(Exception e){e.printStackTrace();}
        return temp;
    }
    public static void main(String args[]) throws ParserConfigurationException, TransformerException, IOException{
        Exam ex = new Exam();
        AES.Model.Question q1 = new AES.Model.Question();
        q1.setMessage("Question 1");
        q1.addPossibleAnswer("Answer1");
        q1.addPossibleAnswer("Answer2");
        q1.addCorrecteAnswer("Answer1");
        ex.addQuestion(q1);
        AES.Model.Question q2 = new AES.Model.Question();
        q2.setMessage("Question 2");
        q2.addPossibleAnswer("Answer1");
        q2.addPossibleAnswer("Answer2");
        q2.addCorrecteAnswer("Answer2");
        ex.addQuestion(q2);
        ex.generateXMLToDefaultPath("exam2");
        
        
    }

    public static void addExam(Exam ex) {
        ExamDAO.addExam(ex.getTitle(), ex.getDescription(), ex.getFilepath(), ex.getCreatorid(), ex.getScore());
    }
}
