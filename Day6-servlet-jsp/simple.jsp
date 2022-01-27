<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!--  <p>This is small paragraph</p> -->

<%--
	String str = "Majrul";
--%>

<%!
	int hitCounter = 1;
%>

<h3>This page has been visited <%= hitCounter++ %> time(s)..</h3>

<center>
<%
	for(int i=1; i<=6; i++) {
%>
	<font size="<%= i %>">Hello World</font><br />
<%
	}
%>
</center>
</body>
</html>