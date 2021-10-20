package com.svig.techstore.core.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "techstore")
public class User{

	@Id
	private String email;
	
	private String fname;
	private String lname;
	private String password;
	
	public User() {
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
	public int hashCode() {
		return email.hashCode();
	}
	
	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer("User[");
		buff.append("email: " + email);
		buff.append(", fname: " + fname);
		buff.append(", lname: " + lname);
		buff.append("]");
		
		return buff.toString();
	}
}
