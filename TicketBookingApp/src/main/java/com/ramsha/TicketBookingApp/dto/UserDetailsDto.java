package com.ramsha.TicketBookingApp.dto;

public class UserDetailsDto {
	private String fname;
	private String lname;
	private String phone;
	private String username;
	private String password;
	
	
public UserDetailsDto() {
	
}

public UserDetailsDto(String fname, String lname, String phone, String username, String password ) {
	
	super();
	this.fname = fname;
	this.lname = lname;
	this.phone = phone;
	this.username = username;
	this.password = password;
	
}
public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname=fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname=lname;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone=phone;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username=username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password=password;
}
}
