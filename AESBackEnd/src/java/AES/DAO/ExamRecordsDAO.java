/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.DAO;

import static AES.DAO.ExamDAO.exists;
import static AES.DAO.ExamDAO.getExamByTitle;
import AES.Model.Exam;
import AES.Model.Examrecords;
import AES.Model.User;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asi
 */
public class ExamRecordsDAO {
     public static boolean addExamRecord(int examid,int userid, int score, Date date){
        boolean ok = false;
        try{
        String sql = "Insert into examrecords (examid, userid, score, dateTaken) values(?,?,?,?)";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setInt(1, examid);
        ps.setInt(2, userid);
        ps.setInt(3, score);
        ps.setDate(4, date);
        ps.execute();
        ok=true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ok;
    }
     
      
    public static boolean removeExamRecord(int id) throws IOException, ClassNotFoundException, SQLException{
      boolean ok = false;
      if(exists(id)){
      try{
      String sql = "Delete from examrecords where id=?";
      PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
      ps.setInt(1, id);
      ps.execute();
      ok=true;
      }
      catch(Exception e){
          e.printStackTrace();
      }
      }
      else{System.out.println("Doesnt exists");}
      return ok;
    }

    public static List<Examrecords> getAllExamRecords(){
        List<Examrecords> temp  = new ArrayList<>();
        try
        {
            String sql = "Select * from examrecords";
            PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                temp.add(getExamRecordById(rs.getInt("id")));
            }
        }
        catch(Exception e){e.printStackTrace();}
        return temp;
    }
         
     
   public static Examrecords getExamRecordById(int id){
        Examrecords temp = null;
        try{
            if(exists(id)){
        String sql = "Select * from examrecords where id=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
          temp = new Examrecords();
          temp.setExamid(rs.getInt("examid"));
          temp.setId(rs.getInt("id"));
          temp.setDateTaken(rs.getDate("dateTaken"));
          temp.setScore(rs.getInt("score"));
          temp.setUserid(rs.getInt("userid"));
        }
            }
        }catch( Exception e){
            e.printStackTrace();
        }
        return temp;
    }
     
    
    public static boolean exists(int id) throws IOException, ClassNotFoundException, SQLException{
       boolean b=false;
        String query="Select * from examrecords where id=?";
        PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
       b=rs.next();
    return b;
    }
  
     public static boolean editExamRecord(int id, int examid,int userid, int score, Date date) throws IOException, ClassNotFoundException, SQLException{
     boolean ok = false;
     if(exists(id)){
     try{
        String sql="Update examrecords set examid=?,userid=?,score=?,dateTaken=? where id = ?";
        PreparedStatement ps =  DatabaseManager.getInstance().getStatement(sql);
        ps.setInt(1, examid);
        ps.setInt(2, userid);
        ps.setInt(3, score);
        ps.setDate(4, date);
        ps.setInt(5, id);
        ps.execute();
        ok=true;
       }
     catch(Exception e){
            e.printStackTrace();
        }
     }
     else{System.out.println("Doesnt exist");}
     return ok;
     }
     
   public static List<Examrecords> getExamRecordByUserid(int userid){
        Examrecords temp = null;
        List<Examrecords> result= new ArrayList();
        try{
        String sql = "Select * from examrecords where userid=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setInt(1, userid);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
          temp = new Examrecords();
          temp.setExamid(rs.getInt("examid"));
          temp.setId(rs.getInt("id"));
          temp.setDateTaken(rs.getDate("dateTaken"));
          temp.setScore(rs.getInt("score"));
          temp.setUserid(rs.getInt("userid"));
        }
        result.add(temp);
        }catch( Exception e){
            e.printStackTrace();
        }
        return result;
    }
      
   public static List<Examrecords> getExamRecordByExamid(int examid){
        Examrecords temp = null;
        List<Examrecords> result= new ArrayList();
        try{
        String sql = "Select * from examrecords where examid=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setInt(1, examid);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
          temp = new Examrecords();
          temp.setExamid(rs.getInt("examid"));
          temp.setId(rs.getInt("id"));
          temp.setDateTaken(rs.getDate("dateTaken"));
          temp.setScore(rs.getInt("score"));
          temp.setUserid(rs.getInt("userid"));
        }
        result.add(temp);
        }catch( Exception e){
            e.printStackTrace();
        }
        return result;
    }
 
   public static List<User> getExaminers(int examid){
   List<User> examiners = new ArrayList();
   try{
    String sql = "Select userid from examrecords where examid=?";
    PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
    ps.setInt(1, examid);
    ResultSet rs = ps.executeQuery();
     while(rs.next()){
         if(UserDAO.getUserByID(rs.getInt("userid"))!=null){
         examiners.add(UserDAO.getUserByID(rs.getInt("userid")));
         }
        // System.out.println(rs.getInt("userid"));
    }
   }
     catch(Exception e){e.printStackTrace();}
    return examiners;
   }
   
   public static List<Exam> getExams(int userid){
   List<Exam> exams = new ArrayList();
   try{
    String sql = "Select examid, score from examrecords where userid=?";
    PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
    ps.setInt(1, userid);
    ResultSet rs = ps.executeQuery();
     while(rs.next()){
        if(ExamDAO.getExamById(rs.getInt("examid"))!=null){
         exams.add(ExamDAO.getExamById(rs.getInt("examid")));
        }  
    }
   }
     catch(Exception e){e.printStackTrace();}
    return exams;
   }
public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException{
    /*  
    for(User s: getExaminers(3)){
       System.out.println("\t"+ s.getUsername()+ "\t"+ s.getUserid());
       }*/
    for(Exam s: getExams(5)){
       System.out.println("\t"+ s.getTitle()+ "\t"+ s.getDescription() + "\t" +s.getFilepath());
       }
   }
   
   
}
