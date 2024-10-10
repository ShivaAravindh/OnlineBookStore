package com.onllinebookstore.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String bookId;
	private String bookName;
	private String authorName;
	private String genre;
	
	
	public Book(String bookId,String bookName, String authorName, String genre) {
		super();
		this.bookId=bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.genre = genre;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getBookId() {
		return bookId;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public String getGenre() {
		return genre;
	}
	
	
}
