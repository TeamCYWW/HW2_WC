package action;
  
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import model.Book;
import model.User;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import service.BookService;
import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
  
public class EditBookAction extends ActionSupport{


    private static final long serialVersionUID = 18925377774889413L;

    private String use;
    private String cond;
	private String isbn;
	private String bookName;
	private String authorName;
	private String priceCond;
	private BigDecimal price;
	private String category;
	private int store;

	public String getIsbn(){
		return isbn;
	}
	
	public void setIsbn(String value){
		this.isbn=value;
	}
	
	public String getBookName(){
		return bookName;
	}
	
	public void setBookName(String value){
		this.bookName=value;
	}	
	
	public String getPriceCond(){
		return priceCond;
	}
	
	public void setPriceCond(String value){
		this.priceCond=value;
	}

	public String getAuthorName(){
		return authorName;
	}
	
	public void setAuthorName(String value){
		this.authorName=value;
	}
			
	
	
	public BigDecimal getPrice(){
		return price;
	}
	
	public void setPrice(BigDecimal value){
		this.price=value;
	}	
	
	public String getCategory(){
		return category;
	}
	
	public void setCategory(String value){
		this.category=value;
	}
	
	public int getStore(){
		return store;
	}
	
	public void setStore(int value){
		this.store=value;
	}
	
	
    public String getUse(){
    	return use;
    }
    
    public void setUse(String value){
    	this.use=value;
    }
    
    public String getCond(){
    	return cond;
    }
    
    public void setCond(String value){
    	this.cond=value;
    }
    
    
    
    private BookService bookService;

	public BookService getBookService(){
		return this.bookService;
	}
	
	public void setBookService(BookService value){
		this.bookService = value;
	}
    
    
    public String execute() throws Exception{
	    ServletActionContext.getResponse()
	    .setContentType("text/html;charset=utf-8");            

    	String[] result=new String[2];
    	
		Map<String,Object> session= ActionContext.getContext().getSession();
		session.put("bookCount", null);
    	//String isbn, String bookName,String authorName, BigDecimal price, int store
    	if (use.equals("insert")){
        	Book b=new Book(isbn,bookName,authorName,price,category,store);
    		if (bookService.addBook(b)==false){
        	       ServletActionContext.getResponse().getWriter()
        	       .print(
        	       "failed/ISBN should"
        	       + " be unique and cannot be empty");     			
        	}else{
    			ServletActionContext.getResponse()
    			.getWriter().print("success/Delete succeeded");   
         		//System.out.println("success");  
        	     
        	}    

    	}else if(use.equals("edit")){
        	Book b=new Book(isbn,bookName,authorName,price,category,store);

        	bookService.updateBook(b);
    		ServletActionContext.getResponse()
    		.getWriter().print("success/Editing succeeded");     		
        	System.out.println("success");

    	}else if(use.equals("delete")){
    		if (bookService.deleteBook(isbn)==false){
       	       ServletActionContext.getResponse().getWriter()
       	       .print("failed/Cannot delete due to existing constraints");     			
    		}else{
    			ServletActionContext.getResponse().getWriter()
    			.print("success/Delete succeeded");     			
    		}
    	}else if(use.equals("search")){
    		//System.out.println("f**k");


        	if (cond==null){        		
        		session.put("sqlsen",null);
    			ServletActionContext.getResponse().getWriter().print("success/");  
        	}else{
        		String sqlsen="Select * from book where ";
	        if (isbn!=null) {
	        	sqlsen+="ISBN='" + isbn + "' AND ";
	        }
	        if (authorName!=null) {
	        	sqlsen+="author_name='" + authorName + "' AND ";
	        }
	        if (bookName!=null) {
	        	sqlsen+="book_name='" + bookName + "' AND ";
	        }
	        if (priceCond!=null) {
//	    		System.out.println("f**k");
	        	String tmp="";
	        	if (priceCond.equals("E")) {
	        		tmp="=";
	        	}
	        	if (priceCond.equals("G")) {
	        		tmp=">";
	        	}
	        	if (priceCond.equals("S")) {
	        		tmp="<";
	        	}
	        	sqlsen+="price" + tmp + price + " AND ";
	        }
	        if (category!=null) {
	        	sqlsen+="category='" + category + "' AND ";
	        }
	        sqlsen+=" true";
	        if (bookService.getBookCounts(sqlsen)==0){
				ServletActionContext.getResponse().getWriter()
				.print(
				"failed/Cannot find the specific item");  	        	
	        }else{
		        session.put("sqlsen",sqlsen);
				ServletActionContext.getResponse().getWriter().print("success/");  
		        //System.out.println(sqlsen);
	        }
        	}

    	}
    	return null;
   }
  
  

}