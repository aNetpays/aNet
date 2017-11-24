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
	private String userName, userPassMD5, logDate, logTime;
	
	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public userData() {
	
	}
	
	@XmlElement
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@XmlElement
	public String getUserPassMD5() {
		return userPassMD5;
	}

	public void setUserPassMD5(String userPassMD5) {
		this.userPassMD5 = userPassMD5;
	}

	@XmlElement
	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}


	/*This is the main constructor*/
	public userData(String userName, String userPassMD5) {
		this.userName = userName;
		this.userPassMD5 = userPassMD5;
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
		result = prime * result + ((userPassMD5 == null) ? 0 : userPassMD5.hashCode());
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
		if (userPassMD5 == null) {
			if (other.userPassMD5 != null)
				return false;
		} else if (!userPassMD5.equals(other.userPassMD5))
			return false;
		return true;
	}
	
	public String toString() {
		return "userData{"
				+ "userName='" + getUserName() + '\''
				+", userPassMD5='" + getUserPassMD5() + '\'' 
				+", logDate='" + getLogDate() + '\''
				+", logTime='" + getLogTime() + '\''
				+ "}";
	}
	
}
