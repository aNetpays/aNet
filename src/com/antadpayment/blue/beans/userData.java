package com.antadpayment.blue.beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class userData implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id, userName, email, name, lastName, dob_day, dob_month, dob_year, logDate, logTime;
	private boolean complete = false;
	
	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public userData(String idF, String userNameF, String emailF, String nameF, 
			String lastNameF, String dob_dayF, String dob_monthF, String dob_yearF) {
		setId(idF);
		setUserName(userNameF);
		setEmail(emailF);
		setName(lastNameF);
		setLastName(lastNameF);
		setDob_day(dob_dayF);
		setDob_month(dob_monthF);
		setDob_year(dob_yearF);
	}
	
	@XmlElement
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlElement
	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}


	/*This is the main constructor*/
	public userData(String userName) {
		/*
		 * here we got to look for user into data base as per query
		 * select * from user_data where user like 'userName%';
		 */
		
		
		/* here we fill that object (modify as per differences) */
		this.userName = userName;
		Date today = new Date();
		DateFormat todayFormat = DateFormat.getDateInstance();
		logDate = todayFormat.format(today);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		logTime = dtf.format(now);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logTime == null) ? 0 : logTime.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		userData other = (userData) obj;
		if (logTime == null) {
			if (other.logTime != null)
				return false;
		} else if (!logTime.equals(other.logTime))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob_day() {
		return dob_day;
	}

	public void setDob_day(String dob_day) {
		this.dob_day = dob_day;
	}

	public String getDob_month() {
		return dob_month;
	}

	public void setDob_month(String dob_month) {
		this.dob_month = dob_month;
	}

	public String getDob_year() {
		return dob_year;
	}

	public void setDob_year(String dob_year) {
		this.dob_year = dob_year;
	}

	public String toString() {
		return "userData{"
				+ "id ='" +getId() + '\''
				+ ", userName='" + getUserName() + '\''
				+ ", Name='" + getName() + '\''
				+ ", lastName='" + getLastName() + '\''
				+ ", dob_day='" + getDob_day() + '\''
				+ ", dob_month='" + getDob_month() + '\''
				+ ", dob_year='" + getDob_year() + '\''
				+", logDate='" + getLogDate() + '\''
				+", logTime='" + getLogTime() + '\''
				+ "}";
	}
	
}
