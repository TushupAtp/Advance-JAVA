package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	public List<Customer> fetchCustomers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-mysql"); //<persistent-unit name="hibernate-mysql" ...>
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select c from Customer c"); //HQL/JPQL
		List<Customer> list = q.getResultList();
		
		em.close();
		emf.close();
		
		return list;
	}

	public List<Customer> fetchCustomers(String city) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-mysql"); //<persistent-unit name="hibernate-mysql" ...>
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select c from Customer c where c.city = :ct"); //:ct --> named parameter
		q.setParameter("ct", city); //substituting the named parameter with the actual value
		List<Customer> list = q.getResultList();
		
		em.close();
		emf.close();
		
		return list;
	}
	
	public List<Customer> fetchCustomers(String name, String city) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-mysql"); //<persistent-unit name="hibernate-mysql" ...>
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select c from Customer c where c.name like :nm and c.city = :ct"); //:ct --> named parameter
		q.setParameter("nm", "%" + name +"%");
		q.setParameter("ct", city);
		List<Customer> list = q.getResultList();
		
		em.close();
		emf.close();
		
		return list;
	}
	
	public Customer fetchCustomer(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-mysql"); //<persistent-unit name="hibernate-mysql" ...>
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select c from Customer c where c.email = :em");
		q.setParameter("em", email);
		Customer cust = (Customer) q.getSingleResult();
		
		em.close();
		emf.close();
		
		return cust;
	}

	public Customer fetchCustomer(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-mysql"); //<persistent-unit name="hibernate-mysql" ...>
		EntityManager em = emf.createEntityManager();
		
		Customer cust = em.find(Customer.class, id); //find method will fetch data based on pk column
		
		em.close();
		emf.close();
		
		return cust;
	}

}
