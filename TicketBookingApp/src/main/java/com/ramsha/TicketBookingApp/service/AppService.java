package com.ramsha.TicketBookingApp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramsha.TicketBookingApp.dao.AppDao;

@Service
public class AppService {
	@Autowired
	AppDao appDao;
	@Autowired
	DataSource dataSource;
	public String signup(String fname, String lname, String phone, String username, String password2) throws SQLException
	{
		
		try(Connection connection = dataSource.getConnection()){
			int loginId = appDao.createLoginDetails(connection,fname, lname, phone,username,password2);
			appDao.createUserDetails(connection,loginId, fname, lname, phone, username, password2);
		}
		return fname + lname + phone;
	}
}
