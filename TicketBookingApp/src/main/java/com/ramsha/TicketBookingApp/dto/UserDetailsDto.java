package com.ramsha.TicketBookingApp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class UserDetailsDto {
	private String fname;
	private String lname;
	private String phone;
	private String username;
	private String password;
	private Integer loginId;
	private Integer userId;
}