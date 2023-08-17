package com.ramsha.TicketBookingApp.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ramsha.TicketBookingApp.dto.UserDetailsDto;
import com.ramsha.TicketBookingApp.service.AppService;

@RestController
public class AppController {
	@Autowired
	AppService appService;
    @GetMapping("/hello")
    public String helloWorld (){

        return "Hello World";
        
    }
    
    @PostMapping("/signup")
    public String userSignup (@RequestBody UserDetailsDto userDetailsDto) throws SQLException{
    	
    	UserDetailsDto response = appService.signup(userDetailsDto);
    	
        return "You've signed up successfully!!!" + response.toString();
    }
    
    
}
//save hash of table, get userId, particular authorization type