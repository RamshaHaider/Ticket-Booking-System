package com.ramsha.TicketBookingApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.ramsha.TicketBookingApp.constant.UserConstant;

@Repository
public class AppDao {
	public void createUserDetails(Connection connection, int loginId2, String fname, String lname, String phone,
			String username, String password2) throws SQLException {
		try (PreparedStatement pst = connection.prepareStatement(UserConstant.CREATE_USERDETAILS)) {
			pst.setInt(1, loginId2);
			pst.setString(2, fname);
			pst.setString(3, lname);
			pst.setString(4, phone);
			pst.setString(5, null);
			pst.setString(6, null);
			pst.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int createLoginDetails(Connection connection, String fname, String lname, String phone, String username,
			String password2) throws SQLException {
		int loginId = 0;
		try (PreparedStatement pst = connection.prepareStatement(UserConstant.CREATE_LOGINDETAILS,
				PreparedStatement.RETURN_GENERATED_KEYS);) {
			pst.setString(1, username);
			pst.setString(2, password2);
			pst.setString(3, null);
			pst.setString(4, null);
			loginId = pst.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return loginId;
	}
}
