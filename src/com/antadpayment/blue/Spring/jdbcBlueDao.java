package com.antadpayment.blue.Spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import com.antadpayment.blue.beans.userData;

public class jdbcBlueDao implements blueDao {
	private DataSource dataSource;
	
	public void setDataSource(DataSource datasource) {
		this.dataSource = datasource;
	}
	
	
	/*
	 * This method should create a new user into DB 
	 * function 
	 * receives: userData object
	 * returns: nothing
	 */
	public void inserUser(userData newUser){
		String qryInserUsr ="INSERT INTO user_data (user, email, name, lastName, dob_day, dob_month,  dob_year)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?);";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(qryInserUsr);
			ps.setString(1, newUser.getUserName());
			ps.setString(2, newUser.getEmail());
			ps.setString(3, newUser.getName());
			ps.setString(4, newUser.getLastName());
			ps.setString(5, newUser.getDob_day());
			ps.setString(6, newUser.getDob_month());
			ps.setString(7, newUser.getDob_year());
			
			//EXECUTE INSERT or UPDATE
			ps.executeUpdate();
			
			ps.close();
		}catch (SQLException sqlErr) {
			System.err.println("[Execution error] : " + sqlErr.getMessage());
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					System.err.println("[Execution error] : " + e.getMessage());
				}
				
			}
		}
		
		
	}
	
	/*
	 * This method retrieves userData object
	 * function
	 * receives: String User nickname
	 * returns: userData object 
	 */
	public userData findUser(String myUser){
		userData userFound = null;
		
		String sqlQry = "SELECT * FROM user_data WHERE user like ?";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlQry);
			ps.setString(1, myUser);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				userFound = new userData(rs.getString("id"), rs.getString("user"), rs.getString("email"), rs.getString("name"), rs.getString("lastName"),
						rs.getString("dob_day"), rs.getString("dob_month"), rs.getString("dob_year"));
				Date today = new Date();
				DateFormat myDate = new SimpleDateFormat("dd/MM/yyyy");
				DateFormat myTime = new SimpleDateFormat("HH:mm:ss");
				userFound.setLogDate(myDate.format(today));
				userFound.setLogTime(myTime.format(today));
			}
		}catch (SQLException sqlErr) {
			// TODO: handle exception
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					System.err.println("[Execution error] : " + e.getMessage());
				}
				
			}
		}
		
		return userFound;
	}

}
