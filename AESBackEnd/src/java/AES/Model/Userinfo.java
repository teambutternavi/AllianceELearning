package AES.Model;
// Generated May 26, 2015 3:13:52 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Userinfo generated by hbm2java
 */
public class Userinfo  implements java.io.Serializable {


     private int userid;
     private User user;
     private String firsname;
     private String lastname;
     private Integer age;
     private String department;
     private int position;

    public Userinfo() {
    }

	
    public Userinfo(User user) {
        this.user = user;
    }
    public Userinfo(User user, String firsname, String lastname, Integer age, String department, int position) {
       this.user = user;
       this.firsname = firsname;
       this.lastname = lastname;
       this.age = age;
       this.department = department;
       this.position = position;
    }
   
    public int getUserid() {
        return this.userid;
    }
    
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getFirsname() {
        return this.firsname;
    }
    
    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getPosition() {
        return this.position;
    }
    
    public void setPosition(int position) {
        this.position = position;
    }




}


