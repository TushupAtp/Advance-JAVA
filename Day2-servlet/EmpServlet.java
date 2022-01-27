package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/emp.xls")
public class EmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel"); //MIME
		
		PrintWriter out = response.getWriter();
		//can we use jdbc here? can we write select query and fetch employee data from some table and return the same
		out.println("Empno\tName\tSalary");
		out.println("1001\tMajrul\t1000");
		out.println("1002\tKiran\t1000");
		out.println("1003\tVipul\t1000");	
	}

}
