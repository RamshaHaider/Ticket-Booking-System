package com.ramsha.TicketBookingApp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ramsha.TicketBookingApp.service.AppService;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AppController {
	@Autowired
	AppService appService;
    @GetMapping("/hello")
    public String helloWorld (){

        return "Hello World";
        
    }
    
    @GetMapping("/signup")
    public String userSignup (@RequestParam String fname, String lname, String phone, String username, String password) throws SQLException{
    	
    	String response = appService.signup(fname, lname, phone, username, password);
    	
        return "You've signed up successfully!" + response;
    }
    
    
}
//save hash of table, get userId, particular authorization type