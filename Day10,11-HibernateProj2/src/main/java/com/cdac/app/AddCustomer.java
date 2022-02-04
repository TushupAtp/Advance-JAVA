package com.cdac.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Customer;

public class AddCustomer {

	public static void main(String[] args) {
		//Step 1. Create/Obtain EntityManagerFactory object
		//During this step persistence.xml file will be read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate-mysql"); //<persistent-unit name="hibernate-mysql" ...>
		
		//Step 2. Create/Obtain EntityManager object
		//Creating this object is similar to Statement/PreparedStatement object in JDBC
		//using which we will perform SQL operations
		EntityManager em = emf.createEntityManager();
		
		//Step 3. Start/Participate a/in a transaction
		//DML operations cannot be performed without an active tx
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//Now we can insert/update/delete/select whatever we want
		Customer c = new Customer();
		c.setName("Govind Kulkarni");
		c.setEmail("govind@gmail.com");
		c.setCity("Pune");
		em.persist(c); //persist method will generate insert query
		
		tx.commit();
		
		//closing the resources should be in finally block
		em.close();
		emf.close();
	}
}
