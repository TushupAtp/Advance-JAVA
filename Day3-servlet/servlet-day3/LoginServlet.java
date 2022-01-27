package com.cdac.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.cdac")
public class LoginServlet extends HttpServlet {

	//int counter = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		if(username.equals("majrul") && password.equals("123"))
			response.sendRedirect("welcome.html");
		else
			//TODO: allow 3 attempts
			//after 3 attempts the user should not be allowed to login again
			//one option is to disable the login button in the html page
			response.sendRedirect("login.html?error=1");
	}

}
