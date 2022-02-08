<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<h3>Welcome back, ${ customer.name }</h3>
<p>
	Mobile Number : ${ customer.mobileNumber } <br />
	City :  ${ customer.address.city } <br />
	Pincode : ${ customer.address.pincode } <br />
</p>
</body>
</html>