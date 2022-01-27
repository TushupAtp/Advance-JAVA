package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/calc.cdac")
public class CalculatorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<form action='calc.cdac'>");
		out.println("Enter number1 : <input type=\"number\" name = \"no1\" /> <br />");
		out.println("Enter number2 : <input type=\"number\" name = \"no2\" /> <br />");
		out.println("<button type=\"submit\">Add</button>");
		out.println("</form>");
		
		if(request.getParameter("no1") != null && request.getParameter("no2") != null) {
			int no1 = Integer.parseInt(request.getParameter("no1"));
			int no2 = Integer.parseInt(request.getParameter("no2"));
			int result = no1 + no2;
			out.println("<h1>The sum of " + no1 +" and " + no2 + " is " + result);
		}
		
		out.println("</body></html>");
	}

}
