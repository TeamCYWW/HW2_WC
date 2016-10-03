// default package
// Generated 2014-5-25 23:12:04 by Hibernate Tools 3.4.0.CR1

package model;

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
	private Set orderdetailses = new HashSet(0);

	public Book() {
	}

	public Book(String isbn, String bookName, BigDecimal price, int store) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.price = price;
		this.store = store;
	}

	public Book(String isbn, String bookName,String authorName,
			BigDecimal price, String category,int store) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.authorName=authorName;
		this.price = price;
		this.store = store;
		this.category=category;
	}
	
	public Book(String isbn, String bookName, String authorName,
			BigDecimal price, String category, int store, Set orderdetailses) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
		this.category = category;
		this.store = store;
		this.orderdetailses = orderdetailses;
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

	public Set getOrderdetailses() {
		return this.orderdetailses;
	}

	public void setOrderdetailses(Set orderdetailses) {
		this.orderdetailses = orderdetailses;
	}

}
