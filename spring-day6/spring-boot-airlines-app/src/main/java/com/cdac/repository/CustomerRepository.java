package com.cdac.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends GenericRepository {

	public boolean isValidUser(String email, String password) {
		return (Long) 
				entityManager
				.createQuery("select count(c) from Customer c where c.email = :em and c.password = :pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult() == 1 ? true : false;
	}
}
