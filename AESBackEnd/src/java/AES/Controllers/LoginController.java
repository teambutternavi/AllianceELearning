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
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
    public User verify(
             @RequestParam Map<String,String> requestParams
    ) throws IOException
    {
        String username = requestParams.get("username");
        String password = requestParams.get("password");
        User user = UserDAO.getUserByUsernameAndPassword(username,password );
        
        return user;
    }
    @RequestMapping(value="/test", method = RequestMethod.GET)
    public User test (
            @RequestParam Map<String,String> requestParams
    ){
        String username = requestParams.get("username");
        String password = requestParams.get("password");
        return UserDAO.getUserByUsernameAndPassword(username,password );
    }
   
}
