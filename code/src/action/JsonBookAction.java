package action;
  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
  
public class JsonBookAction extends ActionSupport{

	
	@Resource(name="jdbc/bookstore") DataSource ds;
	
    private static final long serialVersionUID = 18925377774889413L;

    private BookService bookService;
    private int rows;
    private int page;
    
	public BookService getBookService(){
		return this.bookService;
	}
	
	public void setBookService(BookService value){
		this.bookService = value;
	}
    
	
    public int getRows() {
    	return rows; 
    } 
    
    public void setRows(int rows) {
    	this.rows = rows; 
	} 
    
    public int getPage() {
    	return page; 
    } 
    
    public void setPage(int page) {
    	this.page = page; 
    }  
	
	
    
    public String execute() throws Exception {
    	//System.out.println("page=" + page);
		Map<String,Object> session= ActionContext.getContext().getSession();
    	List<Book> list;
    	List<json.Book> list2=new ArrayList<json.Book>();

		String sql=(String)session.get("sqlsen");
		Integer bookCount=(Integer)session.get("bookCount");
    	if (sql==null){
        	list=bookService.getAllBooks((page-1)*rows,page*rows);
        	if (bookCount==null){
        		bookCount=bookService.getBookCounts();
        		session.put("bookCount", bookCount);
        	}
    	}else{
        	list=bookService.getBooks(sql,(page-1)*rows,page*rows);    		
        	if (bookCount==null){
        		bookCount=bookService.getBookCounts(sql);
        		session.put("bookCount", bookCount);

        	}
    	}
    	

    	Map<String, Object> map = new HashMap<String, Object>();
        String status = null;
        
        //System.out.println(list.size());
        if (list.size() > 0){
        	for (int i=0;i<list.size();++i){
        		//System.out.println(list.get(i).getIsbn());
       			list2.add(new json.Book(list.get(i)));
        	}
            status = String.valueOf(list2.size());
            map.put("total",String.valueOf(bookCount));
            map.put("rows", list2 );
        }


//        map.put("status", status);
        ResultUtils.toJson(ServletActionContext.getResponse(), map);
    	return null;
    }
  

}