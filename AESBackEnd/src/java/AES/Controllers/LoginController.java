/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Controllers;

import AES.DAO.UserDAO;
import AES.Model.Course;
import AES.Model.User;
import java.io.IOException;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ted Ian Osias
 */
@RestController
@RequestMapping(value="/user",method=RequestMethod.POST)
public class LoginController {
    @RequestMapping(value="/dashboard",method=RequestMethod.POST)
    public User verify(
             @RequestParam Map<String,String> requestParams
    ) throws IOException
    {
        String username = requestParams.get("username");
        String password = requestParams.get("password");
        System.out.println("Test");
        User user = UserDAO.getUserByUsernameAndPassword(username,password );
        
        return user;
    }
    @RequestMapping(value="/test", method = RequestMethod.GET)
    public Course test (){
        
        Course cs = new Course();
        cs.setId(1);
        cs.setTitle("test1");
        cs.setDescription("test2");
        
        return cs;
        //return "Testing";
    }
   
}
