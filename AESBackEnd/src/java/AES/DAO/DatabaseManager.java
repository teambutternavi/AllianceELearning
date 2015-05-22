/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AES.DAO;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Ted Ian Osias
 */
public class DatabaseManager {
    private static DatabaseManager instance = null;
    private Connection connection = null;
    public static DatabaseManager getInstance() throws IOException, ClassNotFoundException, SQLException {
        if(instance==null)
            instance = new DatabaseManager();
        return instance;
    }
   
    private DatabaseManager() throws IOException, ClassNotFoundException, SQLException{
        Properties prop = new Properties();
        String resource  = "dbProperties.properties";
        InputStream is = DatabaseManager.class.getClassLoader().getResourceAsStream(resource);
        if(is!=null)
            prop.load(is);
        else throw new IOException("dbProperties.properties file not found. Please place it in default packager/src folder.");
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        this.initConnection(driver, url, username, password);
        System.out.println("Database Connection Established.");
        
    }
    
    private void initConnection(String driver,String url,String username,String password) throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        DriverManager.getConnection(url, username, password);
        this.connection = (Connection) DriverManager.getConnection(url, username, password);
    }
    public PreparedStatement getStatement(String query) throws SQLException{
        return connection.prepareStatement(query);
    }
    
    
    
}
