package by.tc.classwork01.entity;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import by.tc.classwork01.helpers.Sha1Encryption;

public class User {
    private int user_id;
    private String login;
    private String password;
    private int role;
    private String passport;
    private String date_order;
    private int delete_status;
    private String FIO;    
    private int phone;
    private int total_cost;
  
   

    public User (int user_id) {
        this.user_id = user_id;
        this.login = "";
        this.password = "";
        this.role = 1;
        this.passport = "";
        this.date_order = "";
        this.delete_status = 0;
        this.FIO = "";
        this.phone = 0;
        this.total_cost = total_cost;
        
        
    }

    public User(int user_id, String login, String password, int role, String passport, String date_order, int delete_status,
    		String FIO, int phone )
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.user_id = user_id;
        this.login = login;
        this.password = Sha1Encryption.encryptPassword(password);
        this.role = role;
        this.passport = passport;
        this.date_order = date_order;
        this.delete_status = delete_status;
        this.FIO = FIO;            
        this.phone = phone;
        
    }

    public User(String login, String password, int role, String passport,
    		String date_order, int delete_status,  String FIO, int phone)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.login = login;
        this.password = Sha1Encryption.encryptPassword(password);
        this.role = role;
        this.passport = passport;
        this.date_order = date_order;
        this.delete_status = delete_status;
        this.FIO = FIO;          
        this.phone = phone;
      
    }
    
    public User(int user_id, int role, String FIO, int phone, String date_order, int delete_status)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
    	this.user_id = user_id;
        this.role = role;
        this.FIO = FIO;          
        this.phone = phone;
        this.date_order = date_order;
        this.delete_status = delete_status;      
    }

    public User(String login, int phone) {
        this.login = login;
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFIO() {
		return FIO;
	}
    
    public void setFIO(String fIO) {
		FIO = fIO;
	}

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    public String getDate_order() {
		return date_order;
	}
    
    public void setDate_order(String date_order) {
		this.date_order = date_order;
	}

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getDelete_status() {
        return delete_status;
    }

    public void setDelete_status(int delete_status) {
        this.delete_status = delete_status;
    }

	public int getTotalCost() {
		return total_cost;
	}

}

