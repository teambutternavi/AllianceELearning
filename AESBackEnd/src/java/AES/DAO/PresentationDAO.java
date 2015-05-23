/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.DAO;

import AES.Model.Presentation;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asi
 */
public class PresentationDAO {
    public static void addPresentation(String title,String filepath,String author,int creatorid) throws IOException, ClassNotFoundException, SQLException, Exception{
            if(!contains(title)){
             String query="Insert into presentation title,author,filepath,creatorid) values(?,?,?,?)";
             PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
             ps.setString(1, title);
             ps.setString(2, author);
             ps.setString(3,filepath);
             ps.setInt(4, creatorid);
             ps.execute();
            }
            else throw new Exception("title already exists");
    
    }
        public static void addPresentation(String title,String filepath,String author,int creatorid,String description) throws IOException, ClassNotFoundException, SQLException, Exception{   
               if(!contains(title)){
             String query="Insert into presentation (title,author,filepath,creatorid,description) values(?,?,?,?,?)";
            PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
             ps.setString(1, title);
             ps.setString(2, author);
             ps.setString(3,filepath);
             ps.setInt(4, creatorid);
             ps.setString(5,description);
             ps.execute();
               }
               else throw new Exception("title already exists") ;
                
    
    }
                public static void addPresentation(Presentation p) throws IOException, ClassNotFoundException, SQLException, Exception{   
               if(!contains(p.getTitle())){
             String query="Insert into presentation (title,author,filepath,creatorid,description) values(?,?,?,?,?)";
            PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
             ps.setString(1, p.getTitle());
             ps.setString(2, p.getAuthor());
             ps.setString(3,p.getFilepath());
             ps.setInt(4, p.getCreatorId());
             ps.setString(5,p.getDescription());
             ps.execute();
               }
               else throw new Exception("title already exists") ;
                
    
    }
    public static void deletePresentation(int id) throws IOException, ClassNotFoundException, SQLException
    {
           try{    
               if(contains(id)){
                    String query="Delete from presentation where id=?";
                    PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
                    ps.setInt(1,id);
                    ps.execute();}
            }
           catch(Exception e){e.printStackTrace();}
    }
       public static void deletePresentation(String title) throws IOException, ClassNotFoundException, SQLException
    {
           try{    
               if(contains(title)){
                    String query="Delete from presentation where title=?";
                    PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
                    ps.setString(1,title);
                    ps.execute();}
            }
           catch(Exception e){e.printStackTrace();}
    }
    public static Presentation selectPresentation(String title) throws IOException, ClassNotFoundException, SQLException, Exception
    {
         Presentation p=new Presentation();
        if(contains(title)){
       
        String query="Select * from presentation where title=?";
        PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
        ps.setString(1, title);
        ResultSet rs=ps.executeQuery();
       rs.next();
       p.setAuthor(rs.getString("author"));
       p.setCreatorId(rs.getInt("creatorID"));
       p.setFilepath(rs.getString("filepath"));
       p.setId(rs.getInt("id"));
       p.setTitle(rs.getString("title"));
       p.setDescription(rs.getString("description"));
     
        }
        else throw new Exception("presentation does not exist");
          return p;
    }
    public static Presentation getPresentationByID(int id) throws IOException, ClassNotFoundException, SQLException, Exception
    {
          Presentation p=new Presentation();
        if(contains(id)){
       
        String query="Select * from presentation where id=?";
        PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
       rs.next();
       p.setAuthor(rs.getString("author"));
       p.setCreatorId(rs.getInt("creatorID"));
       p.setFilepath(rs.getString("filepath"));
       p.setId(rs.getInt("id"));
       p.setTitle(rs.getString("title"));
        }
        else throw new Exception("presentation does not exist");
          return p;
    }
        public static List<Presentation> selectAllPresentation() throws IOException, ClassNotFoundException, SQLException, Exception
    {
         List<Presentation> p=new ArrayList<>();
         String query="Select * from presentation";
         ResultSet rs=DatabaseManager.getInstance().getStatement(query).executeQuery();
         while(rs.next())
         {
             Presentation pre=new Presentation();
             pre.setAuthor(rs.getString("author"));
             pre.setCreatorId(rs.getInt("creatorID"));
             pre.setFilepath(rs.getString("filepath"));
             pre.setId(rs.getInt("id"));
             pre.setTitle(rs.getString("title"));
             p.add(pre);
         }         
         return p;
    }
public static void editPresentation(String filepath,String description,String title) throws IOException, ClassNotFoundException, SQLException
{
    try
    {
      if(contains(title)){
        String query="Update presentation set filepath=?,description=? where title=?";
        PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
        ps.setString(1, filepath);
        ps.setString(2,description);
        ps.setString(3,title);
        ps.execute();
      }
      else throw new Exception("presentation does not exist");
    }
    catch(Exception e){e.printStackTrace();}
}
public static boolean contains(String title) throws IOException, ClassNotFoundException, SQLException
{
        boolean b=false;
        String query="Select * from Presentation where title=?";
        PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
        ps.setString(1,title);
        ResultSet rs=ps.executeQuery();
       b=rs.next();
    return b;
}
public static boolean contains(int id) throws IOException, ClassNotFoundException, SQLException
{
        boolean b=false;
        String query="Select * from Presentation where id=?";
        PreparedStatement ps=DatabaseManager.getInstance().getStatement(query);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
       b=rs.next();
    return b;
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, Exception {
           
    }
    
}
