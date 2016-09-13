package com.leonardorifeli.hermes.api.core.business.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

public class UserService {
	
	@PersistenceContext(unitName = "user", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
	
	private EntityManager getEm() {
		return this.entityManager;
	}

}