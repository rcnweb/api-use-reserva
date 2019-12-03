package com.usereserva.domain.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.usereserva.domain.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>{

	List<Person> findByName(String name);
	
}
