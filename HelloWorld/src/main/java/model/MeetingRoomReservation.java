package model;

import java.sql.Date;
import java.sql.Time;

public class MeetingRoomReservation {
	
	private int meetingRoomID;
	private int roomNum;//1 to 5
	private Date date;
	private Time timeIn;
	private Time timeOut;
	
	public MeetingRoomReservation(){}
	
	public MeetingRoomReservation(int roomNum, Date date, Time timeIn, Time timeOut) {
		this.roomNum = roomNum;
		this.date = date;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}
	public int getMeetingRoomID() {
		return meetingRoomID;
	}

	public void setMeetingRoomID(int meetingRoomID) {
		this.meetingRoomID = meetingRoomID;
	}

	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(Time timeIn) {
		this.timeIn = timeIn;
	}
	public Time getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(Time timeOut) {
		this.timeOut = timeOut;
	}
	
	

}
