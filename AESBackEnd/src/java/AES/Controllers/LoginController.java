/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Controllers;

import AES.DAO.UserDAO;
import AES.Model.User;
import AES.Utility.UserControlListener;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Ted Ian Osias
 */
@Controller
//@RequestMapping(value="/user",method=RequestMethod.POST)
public class LoginController {
    @RequestMapping(value="/dashboard",method=RequestMethod.POST)
    public String verify(
             @RequestParam Map<String,String> requestParams,
            Model model,
            HttpSession session,
            HttpServletResponse resp
    ) throws IOException
    {
        User user = UserDAO.getUserByUsernameAndPassword(requestParams.get("username"), requestParams.get("password"));
        String returnString = "";
        if(user!=null){
            session.setAttribute("user", user);
            if(user.getUsertype()== UserDAO.UserType_Trainee)
                returnString="traineedashboard";
            else if(user.getUsertype()== UserDAO.UserType_Trainer)
                returnString="trainerdashboard";
            else if(user.getUsertype()== UserDAO.UserType_Admin)
                returnString="admindashboard";
            UserControlListener.activeUsers.add(user);
        }
        else{
            returnString = "index";
        }
        //resp.sendRedirect(returnString);
        return returnString;
        
    }
    
}
