package com.usereserva.domain.service.graphQL.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.usereserva.domain.model.Person;
import com.usereserva.domain.model.input.PersonInput;
import com.usereserva.domain.service.PersonService;

@Component
public class PersonMutation implements GraphQLMutationResolver{
	
	@Autowired
	private PersonService service;
	
	public Person createPerson(PersonInput person) {
		return service.createPerson(person);
	}
	
	public Boolean deletePerson(String id) {
		return service.deletePerson(Long.parseLong(id));
	}
	
	public Person updatePerson(PersonInput input) {
		return service.updatePerson(input);
	}

}
