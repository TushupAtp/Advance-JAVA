<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
<%
	int no1 = Integer.parseInt(request.getParameter("no1"));
	int no2 = Integer.parseInt(request.getParameter("no2"));
	int result = no1 + no2;
%>
<h1>The sum of <%= no1 %> and <%= no2 %> is <%= result %></h1>
</body>
</html>