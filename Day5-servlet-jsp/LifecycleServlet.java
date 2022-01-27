package com.cdac.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifecycleServlet
 */
@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init called..");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet called..");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost called..");
	}

	@Override
	public void destroy() {
		System.out.println("destroy called..");
	}
	
}
