package com.usereserva.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.usereserva.domain.model.Person;
import com.usereserva.domain.model.input.PersonInput;
import com.usereserva.domain.repository.PersonRepositoryCustom;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom{
	
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public List<Person> filter(PersonInput input) {

		List<Person> listPerson = new ArrayList<Person>();
		StringBuilder sql = new StringBuilder();

		sql.append("FROM Person P  WHERE 1 = 1 ");
		
		if(input.getId() != null) {
			sql.append(" AND P.id = :id ");
		}
		
		if(input.getName() != null) {
			sql.append(" AND P.name LIKE :name ");
		}
		
		if(input.getLastName() != null) {
			sql.append(" AND P.lastName LIKE :lastName ");
		}
	
		
		try {

			TypedQuery<Person> query = em.createQuery(sql.toString(), Person.class);
			
			if(input.getId() != null) {
				query.setParameter("id", input.getId());
			}
			
			if(input.getName() != null) {
				query.setParameter("name", input.getName());
			}
			
			if(input.getLastName() != null) {
				query.setParameter("lastName", input.getLastName());
			}
			
			listPerson = query.getResultList();

		} catch (Throwable e) {
			System.out.println(">>> error " + e.getMessage());
		}

		return listPerson;

	

	}

}
