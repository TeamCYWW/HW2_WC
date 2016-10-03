// default package
// Generated 2014-5-25 23:12:04 by Hibernate Tools 3.4.0.CR1

package json;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


public class Book implements java.io.Serializable {

	private String isbn;
	private String bookName;
	private String authorName;
	private BigDecimal price;
	private String category;
	private int store;

	public Book() {
	}

	public Book(model.Book b) {
		this.isbn=b.getIsbn();
		this.bookName=b.getBookName();
		this.authorName=b.getAuthorName();
		this.price=b.getPrice();
		this.category=b.getCategory();
		this.store=b.getStore();
	}

	
	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStore() {
		return this.store;
	}

	public void setStore(int store) {
		this.store = store;
	}


}
