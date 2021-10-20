package com.svig.techstore.core.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "techstore")
public class User{

	@Id
	private int userID;
	
	private String email;
	private String fname;
	private String lname;
	private String password;
	
	public User() {
	}
	
	
	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object other) {
		if(other==null || !(other instanceof User)) {
			return false;
		}
		
		return this.getUserID()== ((User)other).getUserID();
	}
	

	@Override
	public int hashCode() {
		return Integer.hashCode(userID);
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("User[");
		buff.append("userID: " + userID);
		buff.append(", email: " + email);
		buff.append(", fname: " + fname);
		buff.append(", lname: " + lname);
		buff.append("]");
		
		return buff.toString();
	}
}
