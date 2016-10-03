package action;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import model.User;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
  
public class RegisterAction extends ActionSupport {

	
    private static final long serialVersionUID = 18925377774889413L;
	private String name;
    private String password;
    private String root;
    private String email;
    private String nickname;
    
    public String getName(){
    	return name;
    }
    
    public void setName(String value){
    	this.name=value;
    }
    
    public String getPassword(){
    	return password;
    }
    
    public void setPassword(String value){
    	this.password=value;
    }
    
    public String getRoot(){
    	return root;
    }
    
    public void setRoot(String value){
    	this.root=value;
    }

    public String getEmail(){
    	return email;
    }
    
    public void setEmail(String value){
    	this.email=value;
    }
    
    public String getNickname(){
    	return nickname;
    }
    
    public void setNickname(String value){
    	this.nickname=value;
    }

    private UserService userService;

	public UserService getUserService(){
		return this.userService;
	}
	
	public void setUserService(UserService userService){
		this.userService = userService;
	}
    
    
    public String execute() throws Exception{
    	if (userService.existUser(name)){
   	       ServletActionContext.getResponse().getWriter().print("failed"); 
    	}else{
    		User u=new User(name,password,root,email,nickname);    	
    		userService.addUser(u);
    	     ServletActionContext.getResponse().getWriter().print("success"); 
     		System.out.println("success");  
    	     
    	}
    	return null;
   }
  
  
    

}