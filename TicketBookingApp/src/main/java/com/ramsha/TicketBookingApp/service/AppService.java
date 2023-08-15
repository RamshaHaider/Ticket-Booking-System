package com.ramsha.TicketBookingApp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramsha.TicketBookingApp.dao.AppDao;

@Service
public class AppService {
	static final String url = "jdbc:mysql://127.0.0.1:3306/ttbs";
    static final String user = "root";
    static final String password = "22Ekish@22";
	@Autowired
	AppDao appDao;
	public String signup(String fname, String lname, String phone, String username, String password2) throws SQLException
	{
		
		Connection connection = null ;
		connection = DriverManager.getConnection(url,user,password);
		int loginId = appDao.createLoginDetails(connection,fname, lname, phone,username,password2);
		appDao.createUserDetails(connection,loginId, fname, lname, phone, username, password2);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            System.out.println( "Connection successful to database! " );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (connection != null && !connection.isClosed())
            {
                connection.close();
            }
        }
		return fname + lname + phone;
	}
}
