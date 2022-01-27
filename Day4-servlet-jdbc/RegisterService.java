package com.cdac.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterService {

	public void register(String name, String email, String username, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //load/register the driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			stmt = conn.prepareStatement("INSERT INTO customer(name, email, username, password) VALUES(?, ?, ?, ?)");
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, username);
			stmt.setString(4, password);
			stmt.executeUpdate(); //DML
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //rather we should throw some user defined exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
