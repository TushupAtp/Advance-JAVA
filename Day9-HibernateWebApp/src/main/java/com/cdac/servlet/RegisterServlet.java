package com.cdac.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c = new Customer();
		c.setName(request.getParameter("name"));
		c.setEmail(request.getParameter("email"));
		c.setCity(request.getParameter("city"));
		
		CustomerDao dao = new CustomerDao();
		dao.add(c);
		
		response.sendRedirect("thankyou.jsp");
	}

}
