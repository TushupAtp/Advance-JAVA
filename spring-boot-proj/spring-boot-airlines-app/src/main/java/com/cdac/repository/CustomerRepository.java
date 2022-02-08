package com.cdac.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdac.entity.Customer;

@Repository
public class CustomerRepository extends GenericRepository {

	/*public boolean isValidUser(String email, String password) {
		return (Long) 
				entityManager
				.createQuery("select count(c) from Customer c where c.email = :em and c.password = :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult() == 1 ? true : false;
	}*/
	
	public Customer findByEmailAndPassword(String email, String password) {
		return (Customer)
				entityManager
				.createQuery("select c from Customer c where c.email = :em and c.password = :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}
	
	public boolean isCustomerPresent(String email) {
		return (Long) 
				entityManager
				.createQuery("select count(c) from Customer c where c.email = :em")
				.setParameter("em", email)
				.getSingleResult() == 1 ? true : false;
	}
	
	public List<Customer> findAllCustomers() {
		return entityManager
				.createQuery("select c from Customer c")
				.getResultList();
	}
}
