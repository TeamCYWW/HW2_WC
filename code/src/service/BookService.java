package service;

import java.util.List;
import java.util.Set;

import model.Book;
import model.Orderdetails;
import dao.BookDAO;

public class BookService {
	private BookDAO bookDAO;
	
	public void setBookDAO(BookDAO bookDAO){
		this.bookDAO = bookDAO;
	}
	
	public BookDAO getBookDAO(){
		return bookDAO;
	}
	
	public Boolean addBook(Book book) {
		// TODO Auto-generated method stub
		if (book == null){
			return false;
		}
		if (bookDAO.getBookById(book.getIsbn()) != null){
			return false;
		}
		return bookDAO.addBook(book);		
	}

	public Boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		if (book == null){
			return false;
		}
		if (bookDAO.getBookById(book.getIsbn()) == null){
			return false;
		}
		return bookDAO.updateBook(book);
	}

	public Boolean deleteBook(Book book) {
		// TODO Auto-generated method stub
		if (book == null){
			return false;
		}
		if (bookDAO.getBookById(book.getIsbn()) == null){
			return false;
		}
		return bookDAO.deleteBook(book);

	}

	public Boolean deleteBook(String ISBN) {
		// TODO Auto-generated method stub
		if (ISBN == null || ISBN.equals("")){
			return false;
		}
		Book b = bookDAO.getBookById(ISBN);
		if (b == null){
			return false;
		} else {	
			return bookDAO.deleteBook(b);
		}
	}	
	

	public Book getBookById(String ISBN) {
		// TODO Auto-generated method stub
		return bookDAO.getBookById(ISBN);
	}
	
	public List<Book> getAllBooks(){
	
		return bookDAO.getAllBooks();
	}
	
	public List<Book> getAllBooks(int from,int to){
		return bookDAO.getAllBooks(from, to);
	}
	
	public List<Book> getBooks(String sql){
		return bookDAO.getBooks(sql);
	}

	public List<Book> getBooks(String sql,int from,int to){
		return bookDAO.getBooks(sql,from, to);
	}
	
	
	

	public int getBookCounts(){
		return bookDAO.getBookCounts();
	}
	
	
	public int getBookCounts(String sql){
		return bookDAO.getBookCounts(sql);
	}
	
}
