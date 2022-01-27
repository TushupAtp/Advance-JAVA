<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="anothercalc.jsp">
	Enter number1 : <input type="number" name = "no1" /> <br />
	Enter number2 : <input type="number" name = "no2" /> <br />
	<button type="submit">Add</button>
</form>

<%
	if(request.getParameter("no1") != null && request.getParameter("no2") != null) {
		int no1 = Integer.parseInt(request.getParameter("no1"));
		int no2 = Integer.parseInt(request.getParameter("no2"));
		int result = no1 + no2;
%>
	<h1>The sum of <%= no1 %> and <%= no2 %> is <%= result %></h1>
<%
	}
%>

</body>
</html>