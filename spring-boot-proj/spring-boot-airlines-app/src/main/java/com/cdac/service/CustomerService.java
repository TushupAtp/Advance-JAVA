package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dto.LoginDetails;
import com.cdac.entity.Customer;
import com.cdac.exception.CustomerServiceException;
import com.cdac.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmailService emailService;
	
	public int register(Customer customer) {
		if(customerRepository.isCustomerPresent(customer.getEmail()))
			throw new CustomerServiceException("Customer already registered!");
		else {
			customer.setStatus("registered");
			Customer updatedCustomer = (Customer) customerRepository.save(customer);
			//emailService.sendEmailForNewRegistration(customer.getEmail());
			return updatedCustomer.getId();
		}
	}
	
	public void update(Customer customer) {
		customerRepository.save(customer);
	}
	
	public Customer fetch(int id) {
		return customerRepository.findByPK(Customer.class, id);
	}
	
	public List<Customer> fetchAll() {
		return customerRepository.findAllCustomers();
	}

	public Customer login(LoginDetails loginDetails) {
		try {
			Customer customer = customerRepository.findByEmailAndPassword(loginDetails.getEmail(), loginDetails.getPassword());
			return customer;
		}
		catch(EmptyResultDataAccessException e) {
			throw new CustomerServiceException("Invalid Username/Password!");
		}
	}
	
	public void remove(int id) {
		Customer customer = customerRepository.findByPK(Customer.class, id);
		customer.setStatus("inactive");
		customerRepository.save(customer);
	}
	
	public void removePermanently(int id) {
		customerRepository.remove(Customer.class, id);
	}
}
