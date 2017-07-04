package model;

import java.sql.Date;

public class Borrower {
	
	private int borrowerID;
	private String userName;
	private int bookID;
	private Date dateBorrowed;
	private Date dateReturned;
	private boolean returned;
	
	public Borrower(){}
	
	public Borrower(String userName, int bookID, Date dateBorrowed, Date dateReturned,
			boolean returned) {
		this.userName = userName;
		this.bookID = bookID;
		this.dateBorrowed = dateBorrowed;
		this.dateReturned = dateReturned;
		this.returned = returned;
	}

	public int getBorrowerID() {
		return borrowerID;
	}

	public void setBorrowerID(int borrowerID) {
		this.borrowerID = borrowerID;
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

	public Date getDateBorrowed() {
		return dateBorrowed;
	}

	public void setDateBorrowed(Date dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}
	
	

}
