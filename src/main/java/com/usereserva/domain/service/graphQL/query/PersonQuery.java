package com.usereserva.domain.service.graphQL.query;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.usereserva.domain.model.Person;
import com.usereserva.domain.model.input.PersonInput;
import com.usereserva.domain.service.PersonService;

@Component
public class PersonQuery implements GraphQLQueryResolver{
	
	@Autowired
	private PersonService service;
	
    public List<Person> getPersons(PersonInput input) {
    	return service.getPersons(input);
    }
    
    public Optional<Person> getPerson(final Long id) {
        return service.getPerson(id);
    }

}
