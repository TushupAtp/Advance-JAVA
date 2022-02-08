package com.cdac.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository //Alternative to @Component annotation
public class GenericRepository { //Alternative naming convention for Dao

	@PersistenceContext
	protected EntityManager entityManager;
	
	public void save(Object obj) {
		entityManager.merge(obj);
	}
	
	public <E> E findByPK(Class<E> clazz, Object pk) {
		return entityManager.find(clazz, pk);
	}
}
