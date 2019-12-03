package com.usereserva.domain.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.usereserva.domain.repository.ContactRepository;

@Repository
public class ContactRepositoryImpl implements ContactRepository {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void deleteContatoByIdPerson(Long id) {

		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM Contact C ");
		sql.append("  WHERE C.person.id = :id     ");
		try {
			Query query = em.createQuery (sql.toString());
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erro >>");
		} finally {
			System.out.println("deletou >>");
		}

	

	}

}
