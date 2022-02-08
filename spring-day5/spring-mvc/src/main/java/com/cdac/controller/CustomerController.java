package com.cdac.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping("/register.mj")
	//one option to read form data is by using HttpServletRequest object
	//public String register(HttpServletRequest request, Map model) {
	//  String name = request.getParameter("name");
	//  ...
	//  ...
	//second option:
	//spring can automatically read the form/request parameters/data
	//and store the same in an Object for us
	public String register(Customer customer) {
		customerDao.add(customer);
		return "thankyou.jsp";
	}
	
	@RequestMapping("/login.mj")
	public String login(HttpServletRequest request, Map model) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer customer = customerDao.fetch(email, password);
		model.put("customer", customer);
		return "dashboard.jsp";
	}
}
