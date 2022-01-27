package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TatkalBookingServlet
 */
//@WebServlet("/TatkalBookingServlet")
public class TatkalBookingServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("TatkalBookingServlet init called..");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TatkalBookingServlet doGet called..");
		
		ServletConfig config = getServletConfig();
		int bookingStartTime = Integer.parseInt(config.getInitParameter("bookingStartTime"));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//if the user is trying to access this servlet from 10AM onwards, then only proceed.
		//a new rule has come up, that tatkal booking allowed for only 1 hr in the day
		LocalTime time = LocalTime.now();
		if(time.getHour() >= bookingStartTime && time.getHour() <= bookingStartTime + 1)
			out.println("<h1>You can book tatkal tickets now..</h1>");
		else
			out.println("<h3>Sorry, you are not allowed to book tatkal tickets right now</h3>");
	}

}
