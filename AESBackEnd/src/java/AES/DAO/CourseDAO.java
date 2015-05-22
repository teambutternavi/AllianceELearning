/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.DAO;

import AES.Model.Course;
import AES.Model.User;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ted Ian Osias
 */
public class CourseDAO {
        
    public static Course createCourse(String title,String description) throws SQLException, IOException, ClassNotFoundException{
        Date date = Date.valueOf(LocalDate.now());
        String sql = "Insert into Course (title,creation,description) value (?,?,?)";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        Course cs = new Course();
        ps.setString(1, title);
        ps.setString(3, description);
        ps.setDate(2, date);
        ps.execute();
        sql = "Select id from course where title=? and creation=? and description=?";
        ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setString(1, title);
        ps.setString(3, description);
        ps.setDate(2, date);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int id = rs.getInt("id");
        cs.setTitle(title);
        cs.setDescription(description);
        cs.setCreation(date);
        cs.setId(id);
        return cs;
    }
    public static void removeCourse(Course cs)throws IOException, ClassNotFoundException, SQLException{ removeCourse(cs.getId()); }
    public static void removeCourse(int courseid) throws IOException, ClassNotFoundException, SQLException{
        String sql = "Delete from Course where id=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setInt(1, courseid);
        ps.execute();
    }
    public static List<Course> getAllCourse() throws IOException, ClassNotFoundException, SQLException{
        List<Course> temp = new ArrayList<>();
        String sql = "Select * from Course";
        ResultSet rs = DatabaseManager.getInstance().getStatement(sql).executeQuery();
        while(rs.next()){
            Course c1 = new Course();
            c1.setId(rs.getInt("id"));
            c1.setDescription(rs.getString("description"));
            c1.setTitle(rs.getString("title"));
            c1.setCreation(rs.getDate("creation"));
            temp.add(c1);
        }
        return temp;
    }
    public static Course getCourseById(int id) throws SQLException, IOException, ClassNotFoundException{
            Course c1= null;
            String sql = "Select * from Course where id=?";
            PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c1 = new Course();
                c1.setId(rs.getInt("id"));
                c1.setDescription(rs.getString("description"));
                c1.setTitle(rs.getString("title"));
                c1.setCreation(rs.getDate("creation"));
            }
            return c1;
    }
    public static List<Course> getAllCourseTakenBy(int traineeid) throws SQLException, IOException, ClassNotFoundException{
            List<Course> temp = new ArrayList<>();
            String sql = "Select courseid from coursetrainee where traineeid=?";
            PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
            ps.setInt(1, traineeid);
            ResultSet rs = ps.executeQuery();
            Course c1=null;
            while(rs.next()){
                 c1 = getCourseById(rs.getInt("courseid"));
                 if(c1==null){
                     throw new SQLException(rs.getInt("id")+" does not exist.");
                 }else
                     temp.add(c1);
            }
            return temp;
    }
    public static void updateCourse(int id,String title,String description) throws SQLException, IOException, ClassNotFoundException{
        String sql = "Update courses set title=?,description=? where id=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setString(1, title);
        ps.setString(2, description);
        ps.setInt(3, id);
        ps.execute();
    }
    public static boolean exists(Course cs)throws IOException, ClassNotFoundException, SQLException{
        return exists(cs.getId());
    }
    public static boolean exists(int id)throws IOException, ClassNotFoundException, SQLException{
        boolean ok = false;
        String sql = "Select * from course where id=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            ok = true;
        }
        return ok;
    }
    public static void assignTraineeToCourse(User user, Course cs ) throws IOException, ClassNotFoundException, SQLException{
        assignTraineeToCourse(user.getUserid(),cs.getId());
    }
    public static void assignTraineeToCourse(int userid, int courseid) throws IOException, ClassNotFoundException, SQLException{
        String sql = "Insert into coursetrainee values(?,?)";
        if(!exists(courseid)){
            throw new SQLException("Course "+courseid+" not found in database.");
        }
        else if(!UserDAO.exists(userid)){
            throw new SQLException("User "+userid+" not found in database.");
        }
        else if(!UserDAO.isTrainee(userid)){
            throw new SQLException("User "+userid+" is not a trainee");
        }
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setInt(1, courseid);
        ps.setInt(2, userid);
        ps.execute();
    }
    public static void removeTraineeFromCourse(User user, Course cs ) throws IOException, ClassNotFoundException, SQLException{
        removeTraineeFromCourse(user.getUserid(),cs.getId());
    }
    public static void removeTraineeFromCourse(int userid, int courseid) throws IOException, ClassNotFoundException, SQLException{
        String sql = "Delete from coursetrainee where courseid=? and traineeid=?";
        if(!exists(courseid)){
            throw new SQLException("Course "+courseid+" not found in database.");
        }
        if(!UserDAO.exists(userid)){
            throw new SQLException("User "+userid+" not found in database.");
        }
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setInt(1, courseid);
        ps.setInt(2, userid);
        ps.execute();
    }
    public static List<User> getAllUsersTakingCourse(Course cs)throws IOException, ClassNotFoundException, SQLException{
        return getAllUsersTakingCourse(cs.getId());
    }
    public static List<User> getAllUsersTakingCourse(int id)throws IOException, ClassNotFoundException, SQLException{
        List<User> temp = new ArrayList<>();
        String sql = "Select traineeid from coursetrainee where courseid=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            if(UserDAO.exists(rs.getInt("traineeid")))
            temp.add(UserDAO.getUserByID(rs.getInt("traineeid")));
        }
        return temp;
    }
    
}
