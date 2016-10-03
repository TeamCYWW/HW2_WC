package action;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
  
public class LoginAction extends ActionSupport{

	
	@Resource(name="jdbc/bookstore") DataSource ds;
	
    private static final long serialVersionUID = 18925377774889413L;
	private String username;
    private String password;
    private String msg="Welcome";
    private UserService userService;

	public UserService getUserService(){
		return this.userService;
	}
	
	public void setUserService(UserService userService){
		this.userService = userService;
	}
    
    
    public String execute() throws Exception{
//		System.out.println("f**k");    		
    	
    	if (userService.validateUser( username ,password)){
    		ActionContext.getContext().getSession().put("username", username); 
    		if (userService.getUserByName(username).getRoot().equals("T")){
        		ActionContext.getContext()
        		.getSession().put("root",true);     			
        		return "root";    			
    		}else {
        		ActionContext.getContext()
        		.getSession().put("root",false);     			
    			return "user";
    		}
    	}else{
    		msg="User name or password is wrong";
    		return "failed";
    	}
    }
  
    public String getUsername(){
        return username;
    }
  
    public void setUsername(String value){
          this.username = value;
    }
  
    public String getPassword(){
        return password;
    }  
    
    public void setPassword(String value){
        this.password = value;
    }
    
    public String getMsg(){
    	return msg;
    }
    
    public void setMsg(String value){
    	this.msg=value;
    }
    

}