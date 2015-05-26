/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Controllers;

import java.util.Enumeration;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asi
 */
@RestController
@RequestMapping(value = "/file", method = RequestMethod.POST)
public class FileController {
    
    @RequestMapping(value = "/upload", method=RequestMethod.GET)
    public void upload(HttpServletRequest req,@RequestParam Map<String,String> requestParams){
        
       
    }
}
