/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Utility;

import AES.Model.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

/**
 *
 * @author Ted Ian Osias
 */
public class UserControlListener implements javax.servlet.http.HttpSessionListener{
    public static List<User> activeUsers = new ArrayList<>();
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession hs = se.getSession();
        User sb = (User) hs.getAttribute("user");
        activeUsers.remove(sb);
    }
    
}
