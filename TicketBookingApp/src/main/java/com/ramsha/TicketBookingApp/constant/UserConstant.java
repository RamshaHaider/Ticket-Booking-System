package com.ramsha.TicketBookingApp.constant;

public class UserConstant {
	public static final String CREATE_USERDETAILS= "Insert into userdetailstable ( loginId,FName,LName,Phone,email,city) values(?, ?, ?, ?, ?, ?)";
	public static final String CREATE_LOGINDETAILS = "Insert into logintable (UserName, Pword, Token, AutherizationType) values (?,?,?,?) ";
}
