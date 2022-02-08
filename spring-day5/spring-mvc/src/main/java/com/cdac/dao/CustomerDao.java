package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.cdac.entity.Customer;

@Component
public class CustomerDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void add(Customer customer) {
		entityManager.persist(customer);
	}
	
	public Customer fetch(String email, String password) {
		return (Customer) entityManager
				.createQuery("select c from Customer c where c.email = :em and c.password = :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}
}
