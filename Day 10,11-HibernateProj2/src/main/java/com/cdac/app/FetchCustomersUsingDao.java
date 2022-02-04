package com.cdac.app;

import java.util.List;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

public class FetchCustomersUsingDao {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		//List<Customer> list = dao.fetchCustomers();
		//List<Customer> list = dao.fetchCustomers("Mumbai");
		List<Customer> list = dao.fetchCustomers("r", "Mumbai");
		
		for(Customer cust : list)
			System.out.println(cust.getId() + "   " + cust.getName() + "  " + cust.getEmail() + "  " + cust.getCity());

		//Customer c = dao.fetchCustomer("majrul@gmail.com");
		Customer c = dao.fetchCustomer(4);
		System.out.println(c.getId() + "   " + c.getName() + "  " + c.getEmail() + "  " + c.getCity());
	
	}
}
