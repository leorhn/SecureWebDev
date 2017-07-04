package model;

import java.sql.Date;
import java.sql.Time;

public class Review {

	private int reviewID;
	private String review;
	private String userName;
	private int bookID;
	private Date date;
	private Time time;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Review(){}
	
	public Review(String review, String userName, int bookID, Date date, Time time) {
		this.review = review;
		this.userName = userName;
		this.bookID = bookID;
		this.date = date;
		this.time = time;
	}

	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	
	
}
