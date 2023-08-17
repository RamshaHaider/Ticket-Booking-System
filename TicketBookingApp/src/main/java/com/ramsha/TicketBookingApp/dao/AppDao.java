package com.ramsha.TicketBookingApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ramsha.TicketBookingApp.constant.UserConstant;
import com.ramsha.TicketBookingApp.dto.UserDetailsDto;

@Repository
public class AppDao {
	public void createUserDetails(Connection connection, UserDetailsDto userDetailsDto) throws SQLException {
		int userId = 0;
		try (PreparedStatement pst = connection.prepareStatement(UserConstant.CREATE_USERDETAILS,
				PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setInt(1, userDetailsDto.getLoginId());
			pst.setString(2, userDetailsDto.getFname());
			pst.setString(3, userDetailsDto.getLname());
			pst.setString(4, userDetailsDto.getPhone());
			pst.setString(5, null);
			pst.setString(6, null);
			userId = pst.executeUpdate();
			userDetailsDto.setUserId(userId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void createLoginDetails(Connection connection, UserDetailsDto userDetailsDto) throws SQLException {
		int loginId = 0;
		try (PreparedStatement pst = connection.prepareStatement(UserConstant.CREATE_LOGINDETAILS,
				PreparedStatement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, userDetailsDto.getUsername());
			pst.setString(2, userDetailsDto.getPassword());
			pst.setString(3, null);
			pst.setString(4, null);
			loginId = pst.executeUpdate();
			userDetailsDto.setLoginId(loginId);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
