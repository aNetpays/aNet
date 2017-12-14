package com.antadpayment.blue.Spring;

import com.antadpayment.blue.beans.userData;

public interface blueDao {
	/*This method should create a new user into DB*/
	public void inserUser(userData newUser);
	
	/*This method retrives userData object*/
	public userData findUser(String myUser);
	
}
