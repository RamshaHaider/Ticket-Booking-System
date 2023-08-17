package com.ramsha.TicketBookingApp.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramsha.TicketBookingApp.dao.AppDao;
import com.ramsha.TicketBookingApp.dto.UserDetailsDto;

@Service
public class AppService {
	@Autowired
	AppDao appDao;
	@Autowired
	DataSource dataSource;
	public UserDetailsDto signup(UserDetailsDto userDetailsDto) throws SQLException
	{
		userDetailsDto.setPassword(new DigestUtils("SHA3-256").digestAsHex(userDetailsDto.getPassword()));

		try (Connection connection = dataSource.getConnection()) {
			connection.setAutoCommit(false);
			appDao.createLoginDetails(connection, userDetailsDto);
			appDao.createUserDetails(connection, userDetailsDto);
			connection.commit();
		}
		return userDetailsDto;
	}
}
