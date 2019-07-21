package com.oracle.vo;

public class Book {

	Integer isbn;
	String bookName;
	Integer price;
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getPrice() {
		return price;
	}
	public Book() {
		super();
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", bookName=" + bookName + ", price=" + price + "]";
	}
	public Book(Integer isbn, String bookName, Integer price) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.price = price;
	}
	public Book(String bookName, Integer price) {
		super();
		this.bookName = bookName;
		this.price = price;
	}
	
	
	
	
}
