package com.cdac.corejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertCustomer {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //load/register the driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			stmt = conn.prepareStatement("INSERT INTO customer(name, email, username, password) VALUES(?, ?, ?, ?)");
			
			System.out.println("Enter your name");
			String name = s.nextLine();
			System.out.println("Enter email address");
			String email = s.nextLine();
			System.out.println("Enter username");
			String username = s.nextLine();
			System.out.println("Enter password");
			String password = s.nextLine();
			
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, username);
			stmt.setString(4, password);
			stmt.executeUpdate(); //DML
			
			System.out.println("Record inserted successfully!");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //rather we should throw some user defined exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

	}
}
