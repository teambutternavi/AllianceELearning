/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.Controllers;

import AES.DAO.PresentationDAO;
import AES.Model.Presentation;
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
@RequestMapping(value="/presentation",method=RequestMethod.POST)
public class PresentationController {
 @RequestMapping(value="/addPresentation",method=RequestMethod.GET)
    public boolean addPresentation(
            @RequestParam Map<String,String> requestParams
    )throws IOException, SQLException, ClassNotFoundException, Exception{
         Presentation p=new Presentation();
         p.setAuthor(requestParams.get("author"));
         p.setCreatorId(Integer.parseInt(requestParams.get("creatorID")));
         p.setDescription(requestParams.get("description"));
         p.setFilepath(requestParams.get("filepath"));
         p.setTitle(requestParams.get("title"));
         PresentationDAO.addPresentation(p);
         return true;
    }
     @RequestMapping(value="/getAllPresentations",method=RequestMethod.GET)
    public List<Presentation> getAllPresentations()throws IOException, SQLException, ClassNotFoundException, Exception{
        return PresentationDAO.selectAllPresentation();
    }
 @RequestMapping(value="/removePresentation",method=RequestMethod.GET)
    public boolean deletePresentation(
            @RequestParam Map<String,String> requestParams
    )throws IOException, SQLException, ClassNotFoundException, Exception{
         PresentationDAO.deletePresentation(requestParams.get("title"));
         return true;
    }
 @RequestMapping(value="/editPresentation",method=RequestMethod.GET)
    public boolean editPresentation(
            @RequestParam Map<String,String> requestParams
    )throws IOException, SQLException, ClassNotFoundException, Exception{
         PresentationDAO.editPresentation(requestParams.get("filepath"),requestParams.get("description"),requestParams.get("title"));
         return true;
    }
     @RequestMapping(value="/getPresentation",method=RequestMethod.GET)
    public Presentation selectPresentation(
            @RequestParam Map<String,String> requestParams
    )throws IOException, SQLException, ClassNotFoundException, Exception{
      return  PresentationDAO.selectPresentation(requestParams.get("title"));
    }
         @RequestMapping(value="/getPresentationByID",method=RequestMethod.GET)
    public Presentation getPresentationByID(
            @RequestParam Map<String,String> requestParams
    )throws IOException, SQLException, ClassNotFoundException, Exception{
      return  PresentationDAO.getPresentationByID(Integer.parseInt(requestParams.get("id")));
    }
             @RequestMapping(value="/containsPresentation",method=RequestMethod.GET)
    public boolean containsPresentation(
            @RequestParam Map<String,String> requestParams
    )throws IOException, SQLException, ClassNotFoundException, Exception{
      return  PresentationDAO.contains(requestParams.get("title"));
    }
   
}
