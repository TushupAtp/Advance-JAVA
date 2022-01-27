<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String str = "Namaste Duniya";
%>
<h1><%= str %></h1>
<h1>Aaj ki taarikh is <%= new Date() %></h1>
</body>
</html>