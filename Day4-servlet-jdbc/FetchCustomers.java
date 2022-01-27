package com.cdac.corejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchCustomers {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			stmt = conn.prepareStatement("SELECT id, name, email FROM customer");
			rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id"); //1
				String name = rs.getString("name"); //2
				String email = rs.getString("email"); //3
				
				System.out.println(id + " | " + name + " | " + email);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
