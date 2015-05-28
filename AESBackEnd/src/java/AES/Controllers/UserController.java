/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Controllers;

import AES.DAO.UserDAO;
import AES.Model.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ted Ian Osias
 */
@RestController
@RequestMapping(value="/user",method=RequestMethod.POST)
public class UserController {
    @RequestMapping(value="/verify",method=RequestMethod.POST)
    public User verify(
             @RequestParam Map<String,String> requestParams
    ) throws IOException
    {
        String username = requestParams.get("username");
        String password = requestParams.get("password");
        User user = UserDAO.getUserByUsernameAndPassword(username,password );
        return user;
    }
    @RequestMapping(value="/trainees",method=RequestMethod.GET)
    public List<User> getAllTrainees() throws IOException, SQLException, ClassNotFoundException{
        return UserDAO.getAllTrainees();
    }
    @RequestMapping(value="/admins",method=RequestMethod.POST) 
    public List<User> getAllAdmins()throws IOException, SQLException, ClassNotFoundException{
        return UserDAO.getAllAdmin();
    }
    @RequestMapping(value="/trainers",method=RequestMethod.GET)
    public List<User> getAllTrainers()throws IOException, SQLException, ClassNotFoundException{
        return UserDAO.getAllTrainers();
    }
    @RequestMapping(value="/addUser",method=RequestMethod.POST)
    public boolean addUser(
            @RequestParam Map<String,String> requestParams
    )throws IOException, SQLException, ClassNotFoundException{
          User user = new User();
          user.setUsername(requestParams.get("username"));
          user.setPassword(requestParams.get("password"));
          user.setUsertype(Integer.parseInt(requestParams.get("type")));
          return UserDAO.addUser(user);
    }
    @RequestMapping(value="/editUser",method=RequestMethod.POST)
    public boolean editUser(
            @RequestParam Map<String,String> requestParams
    )
    {
        int id = Integer.parseInt(requestParams.get("id"));
        String username =requestParams.get("username"),password=requestParams.get("password");
        int type = Integer.parseInt(requestParams.get("type"));
        User user = new User();
        user.setUserid(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setUsertype(type);
        return editUser(user);
    }
    @RequestMapping(value="/editUser",method=RequestMethod.POST)
    public boolean editUser(@RequestBody User user){
        return UserDAO.editUser(user);
    }
    
    @RequestMapping(value="/deleteUser",method=RequestMethod.POST)
    public boolean deleteUser(@RequestBody User user){
        return UserDAO.removeUser(user);
    }
    @RequestMapping(value="/deleteUser",method=RequestMethod.POST)
    public boolean deleteUser(@RequestParam Map<String,String> requestParams){
        return UserDAO.removeUser(requestParams.get("username"),requestParams.get("password"));
    }
    
    
   
}
