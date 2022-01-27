package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleFormServlet
 */
@WebServlet("/process-form.cdac")
public class SimpleFormServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nameOfThePerson");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello " + name + ". Have a wonderful day ahead!</h1>");
		
	}

}
