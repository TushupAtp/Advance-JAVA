<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learning HTTP Headers</title>
</head>
<body>
<h3>Hello. It seems you are using : <%= request.getHeader("user-agent") %></h3>
</body>
</html>