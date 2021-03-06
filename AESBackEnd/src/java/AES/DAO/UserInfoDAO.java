/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.DAO;

import AES.Model.User;
import AES.Model.Userinfo;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asi
 */
public class UserInfoDAO {
    public static void addUserInfo(int userid, String firstname,String lastname,int age, String department,int position)throws IOException, ClassNotFoundException, SQLException, Exception
    {
        if(UserDAO.exists(userid)){
        String query="Insert into userinfo (userid,firstname,lastname,age,department,position) values(?,?,?,?,?,?)";
        PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
        ps.setInt(1,userid);
        ps.setString(2,firstname);
        ps.setString(3,lastname);
        ps.setInt(4,age);
        ps.setString(5,department);
        ps.setInt(6,position);
        ps.execute();
        }
        else throw new SQLException("user does not exist");
    }
    
    public static void removeUserInfo(int userid)throws IOException, ClassNotFoundException, SQLException
    {
        if(contains(userid)){
        String query="Delete from userinfo where userid=?";
        PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
        ps.setInt(1,userid);
        ps.execute();}
        else throw new SQLException("user does not exist");
    }
    public static void editUserInfo(int userid, String firstname,String lastname,int age, String department,int position)throws IOException, ClassNotFoundException, SQLException
    { if(contains(userid)){
        String query="Update userinfo set firstname=?,lastname=?,age=?,department=?,position=? where userid=?";
        PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
        ps.setString(1,firstname);
        ps.setString(2,lastname);
        ps.setInt(3,age);
        ps.setString(4,department);
        ps.setInt(5,position);
        ps.setInt(6,userid);
        ps.execute();
        }
        else throw new SQLException("user does not exist");
    }
    public static boolean contains(int id)
    {
        boolean ok = false;
        try {
            
            
            String query="Select * from userinfo where userid=?";
            PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
                ok = true;
            
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
        return ok;
    }
    public static Userinfo getUserInfoById(int id)
    {
        Userinfo user = null;
        try {
            if(contains(id)){
            
                user=new Userinfo();
                String query="Select * from userinfo where userid=?";
                PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
                ps.setInt(1, id);
                ResultSet rs=ps.executeQuery();
                rs.next();
                user.setUserid(rs.getInt("userid"));
                user.setAge(rs.getInt("age"));
                user.setFirsname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setPosition(rs.getInt("position"));
                user.setDepartment(rs.getString("department"));
                user.setUser(UserDAO.getUserByID(rs.getInt("userid")));
                user.getUser().setUserinfo(user);
            
            }
        } catch (SQLException | IOException | ClassNotFoundException ex) {
                Logger.getLogger(UserInfoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
        
    }
    public static List<Userinfo> getAllUserInfo()throws IOException, ClassNotFoundException, SQLException
    {
        List<Userinfo> user=new ArrayList();
        String query="Select * from userinfo";
        ResultSet rs=DatabaseManager.getInstance().getStatement(query).executeQuery();
        while(rs.next())
        {
        Userinfo use=new Userinfo();
        use.setUserid(rs.getInt("userid"));
        use.setAge(rs.getInt("age"));
        use.setFirsname(rs.getString("firstname"));
        use.setLastname(rs.getString("lastname"));
        use.setPosition(rs.getInt("position"));
        use.setDepartment(rs.getString("department"));
        use.setUser(UserDAO.getUserByID(rs.getInt("userid")));
        user.add(use);
        }
        return user;
    }
    public static List<Userinfo> getAllUserByDepartment(String department)throws IOException, ClassNotFoundException, SQLException
  {
     List<Userinfo> user=new ArrayList();
        String query="Select * from userinfo where department=?";
         PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
         ps.setString(1,department);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        Userinfo use=new Userinfo();
        use.setUserid(rs.getInt("userid"));
        use.setAge(rs.getInt("age"));
        use.setFirsname(rs.getString("firstname"));
        use.setLastname(rs.getString("lastname"));
        use.setPosition(rs.getInt("position"));
        use.setDepartment(rs.getString("department"));
        use.setUser(UserDAO.getUserByID(rs.getInt("userid")));
        user.add(use);
        }
        return user;
  }
    
     public static List<Userinfo> getAllUserByPosition(int pos)throws IOException, ClassNotFoundException, SQLException
  {
      if(pos<4&&pos>-1){
     List<Userinfo> user=new ArrayList();
        String query="Select * from userinfo where position=?";
         PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
         ps.setInt(1,pos);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        Userinfo use=new Userinfo();
        use.setUserid(rs.getInt("userid"));
        use.setAge(rs.getInt("age"));
        use.setFirsname(rs.getString("firstname"));
        use.setLastname(rs.getString("lastname"));
        use.setPosition(rs.getInt("position"));
        use.setDepartment(rs.getString("department"));
        use.setUser(UserDAO.getUserByID(rs.getInt("userid")));
        user.add(use);
        }
        return user;}
      else throw new SQLException("position not valid");
  }
 
    public static void main(String args[])throws IOException, ClassNotFoundException, SQLException, Exception
    {
        
       
    }
}
