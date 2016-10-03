package dao;

//import org.hibernate.Criteria;  
import java.util.List;
import java.util.Set;

import model.Book;
import model.Orderdetails;

import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;



//import org.hibernate.criterion.Restrictions;  
//import org.springframework.beans.factory.annotation.Autowired;  
//import org.springframework.stereotype.Repository;  

public class BookDAO {
	
	private SessionFactory sessionFactory;  
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Boolean addBook(Book book) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.save(book);
			tx.commit();
			session.close();
			return true;
		}catch (Exception e){
			System.out.println(e.getMessage());
			tx.rollback();
			session.close();
			return false;
		}
	}
	
	public Boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(book);
		try{
			tx.commit();
			session.close();
			return true;
		}catch (Exception e){
			tx.rollback();
			session.close();
			return false;
		}
	}
	
	public Boolean deleteBook(Book book) {
		// TODO Auto-generated method stub
		System.out.println("deleteBOok");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(book);
		try{
			tx.commit();
			session.close();
			return true;
		}catch (Exception e){
			tx.rollback();
			session.close();
			return false;
		}
	}
	
	public Book getBookById(String ISBN) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Book b=(Book) session.get(Book.class, ISBN);
		session.close();
		return b;
	}
	
	public List<Book> getAllBooks(){
		//unimplemented
		//return null;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Book> result =  session.createQuery(" From Book").list();
		tx.commit();
		session.close();
		return result;
		
	}
	
	
	public List<Book> getAllBooks(int from,int to){
		//unimplemented
		//return null;
//		System.out.println("from:"+from+" to:"+to);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query q=session.createQuery(" From Book");
		q.setFirstResult(from);
		q.setMaxResults(to-from);
		List<Book> result =  q.list();
		tx.commit();
		session.close();
//		System.out.println("size="+result.size());
		return result;
		
	}
	
	
	public List<Book> getBooks(String sql){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Book> result =  session.createSQLQuery(sql).addEntity(Book.class).list();
		//System.out.println(result.get(0).getBookName());
		tx.commit();
		session.close();
		return result;	
	}
	
	public List<Book> getBooks(String sql,int from,int to){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Book> result =  session.createSQLQuery(sql).addEntity(Book.class)
				.setFirstResult(from).setMaxResults(to-from).list();
		//System.out.println(result.get(0).getBookName());
		tx.commit();
		session.close();
		return result;	
		
		
	}
	
	
	public int getBookCounts(){
		Session session = sessionFactory.openSession();
		Query q=session.createQuery("Select count(b.isbn) From Book b");
		int result = Integer.valueOf(q.uniqueResult().toString());
		session.close();
		return result;		
	}

	public int getBookCounts(String sql){
		Session session = sessionFactory.openSession();
		int pos=sql.indexOf("from");
		sql=sql.substring(pos,sql.length());
		sql="select count(1) " + sql;
		//System.out.println(sql);
		
		Query q=session.createSQLQuery(sql);
		int result = Integer.valueOf(q.uniqueResult().toString());
		session.close();
		return result;		
		
		
	}
	
	
	

}
