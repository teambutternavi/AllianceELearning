package AES.Model;
// Generated May 26, 2015 3:13:52 PM by Hibernate Tools 4.3.1



/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer userid;
     private String username;
     private String password;
     private Integer usertype;
     private Userinfo userinfo;

    public User() {
    }

	
    public User(String username) {
        this.username = username;
    }
    public User(String username, String password, Integer usertype, Userinfo userinfo) {
       this.username = username;
       this.password = password;
       this.usertype = usertype;
       this.userinfo = userinfo;
    }
   
    public Integer getUserid() {
        return this.userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getUsertype() {
        return this.usertype;
    }
    
    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }
    public Userinfo getUserinfo() {
        return this.userinfo;
    }
    
    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }




}


