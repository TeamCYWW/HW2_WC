package service;

import java.util.List;
import java.util.Set;

import model.Book;
import model.Orders;
import model.User;
import dao.UserDAO;

public class UserService {

	private UserDAO userDAO;
	
	public UserService(){}
	
	public UserService(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	public UserDAO getUserDAO(){
		return userDAO;
	}
	
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		if (user == null){
			return false;
		}
		if (user.getName() == null){
			return false;
		}
		if (getUserByName(user.getName())!=null){
			return false;
		}
		return userDAO.addUser(user);
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		if (user == null){
			return false;
		}
		if (user.getName() == null){
			return false;
		}
		return userDAO.deleteUser(user);
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub

		if (user == null){
			return false;
		}
		if (user.getUid() == null){
			return false;
		}
		return userDAO.updateUser(user);

	}

	
	public List<User> getAllUsers(int from,int to){
		return userDAO.getAllUsers(from, to);
	}
	
	

	public User getUserByName(String id) {
		// TODO Auto-generated method stub
		if (id == null){
			return null;
		}
		return userDAO.getUserByName(id);
	}

	public User getUserByUid(int uid){
		if (uid<0){
			return null;
		}
		return userDAO.getUserById(uid);
		
	}
	
	
	public boolean validateUser(String username, String pwd) {
		User userBuf = userDAO.getUserByName(username);
		if (userBuf==null) {
			return false;
		}
		{
			if (pwd.equals(userBuf.getPassword())){
				return true;
			}else{
				return false;
			}
		}
	}
	

	public boolean existUser(String name){
		if (userDAO.getUserByName(name) != null){
			return true;
		}else{
			return false;
		}
	}
	
	public int getUserCounts(){
		return userDAO.getUserCounts();
	}
	
	

	
}
