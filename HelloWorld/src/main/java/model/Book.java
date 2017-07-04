package model;

import java.util.ArrayList;

public class Book {
	
	private int bookID;
	private int location;
	private String title;
	private String author;
	private String publisher;
	private String year;
	private String status;
	private String type;
	private ArrayList<String> tags;
	
	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public Book(){
		tags = new ArrayList<>();
	}
	
	public Book(int location, String title, String author, String publisher, String year, String status,
			String type) {
		this.location = location;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.status = status;
		this.type = type;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	

}
