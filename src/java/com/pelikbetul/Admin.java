package com.pelikbetul;
// Generated Dec 3, 2017 4:04:08 PM by Hibernate Tools 4.3.1



/**
 * Admin generated by hbm2java
 */
public class Admin  implements java.io.Serializable {


     private Integer id;
     private String adminid;
     private String adminpwd;

    public Admin() {
    }

    public Admin(int id,String adminid, String adminpwd) {
       
        this.adminid = adminid;
       this.adminpwd = adminpwd;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAdminid() {
        return this.adminid;
    }
    
    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }
    public String getAdminpwd() {
        return this.adminpwd;
    }
    
    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd;
    }




}


