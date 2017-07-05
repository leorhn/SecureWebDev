package model;

import java.sql.Date;

public class User {
	
	private int userNameID;
	private String firstName;
	private String middleName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String idNumber;
	private Date birthday;
	private int questionID;
	private String answer;
	private String type;
	
	public User(){}
	
	public User(int userNameID, String firstName, String middleName, String lastName, String userName, String password, String email,
			String idNumber, Date birthday, int questionID, String answer, String type) {
		this.userNameID = userNameID;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.idNumber = idNumber;
		this.birthday = birthday;
		this.questionID = questionID;
		this.answer = answer;
		this.type = type;
	}
	
	public int getUserNameID() {
		return userNameID;
	}

	public void setUserNameID(int userNameID) {
		this.userNameID = userNameID;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int question) {
		this.questionID = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
