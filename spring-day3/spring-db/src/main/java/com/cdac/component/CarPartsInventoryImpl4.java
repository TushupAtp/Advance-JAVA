package com.cdac.component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("carParts4")
public class CarPartsInventoryImpl4 implements CarPartsInventory {

	//Instead of @Autowired, we need to use this annotation
	//for injecting EntityManager object
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addNewPart(CarPart carPart) {
		entityManager.persist(carPart);
	}

	public List<CarPart> getAvailableParts() {
		return entityManager
				.createQuery("select cp from CarPart cp")
				.getResultList();
	}

}
