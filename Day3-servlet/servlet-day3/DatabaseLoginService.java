package com.cdac.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * TODO: 
 * 1. copy mysql-connector-java-8.0.xx.jar to the src/main/webapp/WEB-INF/lib folder
 * 2. connect to mysql and create a table where we will store user information:
 * CREATE TABLE customer(id int primary key auto increment, 
 * 						 name varchar(30),
 * 						 email varchar(50),
 * 						 username varchar(15),
 * 						 password varchar(25));
 * INSERT INTO customer(name, email, username, password) VALUES('Majrul Ansari', 'majrul@gmail.com', 'majrul', '123')
 * similarly insert few more records
 */
public class DatabaseLoginService implements LoginService {

	@Override
	public boolean isValidUser(String username, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			stmt = conn.prepareStatement("SELECT count(*) FROM customer WHERE username = ? AND password = ?");
			stmt.setString(1, username); //substituting ? with the actual value
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				if(count == 1)
					return true;
				else
					return false;
			}
			return false;
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //rather we should throw some user defined exception
			return false;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

}
