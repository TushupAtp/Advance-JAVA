package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Customer;

//Classes which contain DB interaction code
//are commonly referred to as Dao classes
//Data Access Object
public class CustomerDao {

	public void add(Customer customer) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-mysql"); //<persistent-unit name="hibernate-mysql" ...>
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(customer);	
		tx.commit();
		em.close();
		emf.close();		
	}
}
