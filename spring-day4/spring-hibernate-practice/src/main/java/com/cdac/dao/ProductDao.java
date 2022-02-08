package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.entity.Product;

@Component
public class ProductDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void add(Product product) {
		entityManager.persist(product);
	}
	
	public List<Product> fetchAllProducts() {
		Query q = entityManager.createQuery("select p from Product p");
		List<Product> list = q.getResultList();
		return list;
	}
}
