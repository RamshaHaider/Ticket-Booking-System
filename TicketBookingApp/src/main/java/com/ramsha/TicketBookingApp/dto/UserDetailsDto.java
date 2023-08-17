package com.ramsha.TicketBookingApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
}