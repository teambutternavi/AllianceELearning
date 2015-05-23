/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.DAO;

import AES.Model.User;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ted Ian Osias
 */
public class UserDAO {
    public static final int UserType_Trainee = 0;
    public static final int UserType_Trainer = 1;
    public static final int UserType_Admin = 2;
    public static boolean addUser(User user){
        return addUser(user.getUsername(),user.getPassword(),user.getUsertype());
    }
    public static boolean addUser(String username,String password, int userType){
        boolean ok = false;
        try{
        String sql = "Insert into user (username, password, usertype) values(?,?,?)";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setString(1, username);
        ps.setString(2,  password);
        ps.setInt(3, userType);
        ps.execute();
        ok = true;
        }
        catch(IOException | ClassNotFoundException | SQLException e){}
        return ok;
    }
    public static boolean removeUser(User user){
        return removeUser(user.getUsername());
    }
    public static boolean removeUser(String username){
        boolean ok = false;
        try{
        String sql = "Delete from user where username=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setString(1, username);
        ok = ps.execute();
        }
        catch(IOException | ClassNotFoundException | SQLException e){}
        return ok;
    }
    public static boolean editUser(User user){
        return editUser(user.getUserid(),user.getUsername(),user.getPassword(),user.getUsertype());
    }
    public static boolean editUser(int userId,String username,String password, int userType){
        boolean ok = false;
        try{
        String sql = "Update user set username=?,password=?,usertype=? where userid=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setInt(3, userType);
        ps.setInt(4, userId);
        ok = ps.execute();
        }
        catch(IOException | ClassNotFoundException | SQLException e){}
        return ok;
    }
    public static User getUserByID(int userId){
        User temp = null;
        try{
        String sql = "Select * from user where userid=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            temp = new User();
            temp.setUserid(rs.getInt("userId"));
            temp.setUsername(rs.getString("username"));
            temp.setPassword(rs.getString("password"));
            temp.setUsertype(rs.getInt("usertype"));
        }
        }catch( IOException | ClassNotFoundException | SQLException e){}
        return temp;
    }
    public static User getUserByUsernameAndPassword(String username,String password){
        User temp = null;
        try{
        String sql = "Select * from user where username=? AND password=?";
        PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
            temp = new User();
        temp.setUserid(rs.getInt("userId"));
        temp.setUsername(rs.getString("username"));
        temp.setPassword(rs.getString("password"));
        temp.setUsertype(rs.getInt("usertype"));
        }catch( IOException | ClassNotFoundException | SQLException e){}
        return temp;
    }
    public static boolean exists(User user){
        return exists(user.getUserid());
    }
    public static boolean exists(int id){
        boolean ok= false;
        if(getUserByID(id)!=null){
            ok=true;
        }
        return ok;
    }
    public static boolean isAdmin(User user){ return user.getUsertype()== UserDAO.UserType_Admin;}
    public static boolean isAdmin(int userid){return isAdmin(getUserByID(userid));}
    public static boolean isTrainee(User user){ return user.getUsertype()== UserDAO.UserType_Trainee;}
    public static boolean isTrainee(int userid){return isTrainee(getUserByID(userid));}
    public static boolean isTrainer(User user){ return user.getUsertype()== UserDAO.UserType_Trainer;}
    public static boolean isTrainer(int userid){return isTrainer(getUserByID(userid));}
    public static List<User> getAllTrainees()throws IOException, SQLException, ClassNotFoundException{ return getAllUserOfType(UserDAO.UserType_Trainee);}
    public static List<User> getAllTrainers()throws IOException, SQLException, ClassNotFoundException{ return getAllUserOfType(UserDAO.UserType_Trainer);}
    public static List<User> getAllAdmin()throws IOException, SQLException, ClassNotFoundException{ return getAllUserOfType(UserDAO.UserType_Admin);}
    public static List<User> getAllUserOfType(int type) throws IOException, SQLException, ClassNotFoundException{
        List<User> temp = null;
        if(!(type < UserDAO.UserType_Trainee || type> UserDAO.UserType_Admin)){
            temp = new ArrayList<>();
            String sql = "Select userid from user where usertype=?";
            PreparedStatement ps = DatabaseManager.getInstance().getStatement(sql);
            ps.setInt(1, type);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
                if(exists(rs.getInt("userid")))
                    temp.add(getUserByID(rs.getInt("userid")));
        }
        return temp;
    }
    public static void main(String args[]){
        try{
            System.out.println(UserDAO.getUserByUsernameAndPassword("ian", "osias"));
        
        }catch(Exception e){ e.printStackTrace();}
        
    }
    
}
