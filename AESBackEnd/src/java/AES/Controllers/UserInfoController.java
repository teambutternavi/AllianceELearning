/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Controllers;

import AES.DAO.UserInfoDAO;
import AES.Model.Userinfo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asi
 */
@RestController
@RequestMapping(value="/Userinfo",method=RequestMethod.POST)
public class UserInfoController {
     @RequestMapping(value="/addUserinfo",method=RequestMethod.GET)
    public void addUserInfo(@RequestParam Map<String,String> requestParams)throws IOException, SQLException, ClassNotFoundException, Exception
    {
        UserInfoDAO.addUserInfo(Integer.parseInt(requestParams.get("userid")),requestParams.get("firstname"), requestParams.get("lastname"),Integer.parseInt(requestParams.get("age")), requestParams.get("department"),Integer.parseInt(requestParams.get("position")));  
    }
     @RequestMapping(value="/deleteUserinfo",method=RequestMethod.GET)
     public void deleteUserInfo(@RequestParam Map<String,String> requestParams)throws IOException, SQLException, ClassNotFoundException, Exception
    {
        UserInfoDAO.removeUserInfo(Integer.parseInt(requestParams.get("userid")));
    }
          @RequestMapping(value="/editUserinfo",method=RequestMethod.GET)
     public void editUserInfo(@RequestParam Map<String,String> requestParams)throws IOException, SQLException, ClassNotFoundException, Exception
    {
        UserInfoDAO.editUserInfo(Integer.parseInt(requestParams.get("userid")),requestParams.get("firstname"), requestParams.get("lastname"),Integer.parseInt(requestParams.get("age")), requestParams.get("department"),Integer.parseInt(requestParams.get("position")));  
    }
            @RequestMapping(value="/getAllUserinfo",method=RequestMethod.GET)
     public List<Userinfo> getAllUserInfo(@RequestParam Map<String,String> requestParams)throws IOException, SQLException, ClassNotFoundException, Exception
    {
       return UserInfoDAO.getAllUserInfo();
    }
         @RequestMapping(value="/getAllUserinfoByDepartment",method=RequestMethod.GET)
     public List<Userinfo> getAllUserInfoByDepartment(@RequestParam Map<String,String> requestParams)throws IOException, SQLException, ClassNotFoundException, Exception
    {
       return UserInfoDAO.getAllUserByDepartment(requestParams.get("department"));
    }
              @RequestMapping(value="/getAllUserinfoByPosition",method=RequestMethod.GET)
     public List<Userinfo> getAllUserInfoByPosition(@RequestParam Map<String,String> requestParams)throws IOException, SQLException, ClassNotFoundException, Exception
    {
       return UserInfoDAO.getAllUserByPosition(Integer.parseInt(requestParams.get("position")));
    }
    
    
    
}
