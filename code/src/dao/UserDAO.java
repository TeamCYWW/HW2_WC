package dao;

//import org.hibernate.Criteria;  
import java.util.List;
import java.util.Set;

import model.Book;
import model.Orders;
import model.User;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;







//import antlr.collections.List;
//import org.hibernate.criterion.Restrictions;  
//import org.springframework.beans.factory.annotation.Autowired;  
//import org.springframework.stereotype.Repository;  




public class UserDAO {
	
	private SessionFactory sessionFactory;  
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public UserDAO(){
	}
	
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.save(user);
			tx.commit();
			session.close();
			return true;
		}catch (Exception e){
			tx.rollback();
			session.close();
			return false;
		}
	}

	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.delete(user);
			tx.commit();
			session.close();
			return true;
		}catch (Exception e){
			tx.rollback();
			session.close();
			return false;
		}
	}

	public User getUserById(int uid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		User buf =  (User) session.get(User.class, uid);
		session.close();
		return buf;
	}
	
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
	    String sql = "from User user where user.name='" +name + "'";  
	    Query query = session.createQuery(sql); 
	    User buf=(User) query.uniqueResult();		
		session.close();
		return buf;
	}	

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.update(user);
			tx.commit();
			session.close();
			return true;
		}catch (Exception e){
			tx.rollback();
			session.close();
			return false;
		}
	}

	public List<User> getAllUsers(){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<User> result =  session.createQuery("From User").list();
		tx.commit();
		session.close();
		return result;
		
	}

	public List<User> getAllUsers(int from,int to){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query q=session.createQuery("From User u where alive=1");
		q.setFirstResult(from);
		q.setMaxResults(to-from);
		List<User> result =  q.list();

		tx.commit();
		session.close();
		return result;
		
	}
		
	
	
	public int getUserCounts(){
		Session session = sessionFactory.openSession();
		Query q=session.createQuery("Select count(u.uid) From User u where alive=1");
		int result = Integer.valueOf(q.uniqueResult().toString());
		session.close();
		return result;		
	}
	
	
}
