<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><th>Customer ID</th><th>Name</th><th>Email Address</th></tr>
<%
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
%>
			<tr>
				<td><%= id %></td>
				<td><%= name %></td>
				<td><%= email %></td>
			</tr>
<%		
		}
	}
	catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	finally {
		try { conn.close(); } catch(Exception e) { }
	}
%>

</table>
</body>
</html>