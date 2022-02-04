package com.cdac.app;

import com.cdac.dao.CustomerDao;
import com.cdac.entity.Customer;

public class AddCustomerUsingDao {

	public static void main(String[] args) {
		Customer c = new Customer();
		c.setName("Aastha Singh");
		c.setEmail("aastha@gmail.com");
		c.setCity("Pune");
		
		CustomerDao dao = new CustomerDao();
		dao.add(c);
	}
}
