package com.cdac.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Address;
import com.cdac.entity.Employee;

public class EmployeeAddressDao {

	public void add(Employee emp) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-mysql"); //<persistent-unit name="hibernate-mysql" ...>
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(emp);	
		tx.commit();
		em.close();
		emf.close();
	}
	
	public void add(Address addr) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-mysql"); //<persistent-unit name="hibernate-mysql" ...>
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(addr);	
		tx.commit();
		em.close();
		emf.close();		
	}
	
	public Employee fetchEmployee(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-mysql"); //<persistent-unit name="hibernate-mysql" ...>
		EntityManager em = emf.createEntityManager();

		Employee emp = em.find(Employee.class, id);
		
		em.close();
		emf.close();
		
		return emp;
	}

	public Address fetchAddress(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-mysql"); //<persistent-unit name="hibernate-mysql" ...>
		EntityManager em = emf.createEntityManager();

		Address addr = em.find(Address.class, id);
		
		em.close();
		emf.close();
		
		return addr;
		
	}

	public void update(Employee emp) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-mysql"); //<persistent-unit name="hibernate-mysql" ...>
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(emp);
		tx.commit();
		em.close();
		emf.close();		
	}
}
