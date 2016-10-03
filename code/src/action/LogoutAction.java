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
  
public class LogoutAction extends ActionSupport {

    private static final long serialVersionUID = 18925377774889413L;

    public String execute() throws Exception {
    	
   		ActionContext.getContext().getSession().put("username", null); 
   		ActionContext.getContext().getSession().put("root", null); 

   		return "success";    			
    }
  


}