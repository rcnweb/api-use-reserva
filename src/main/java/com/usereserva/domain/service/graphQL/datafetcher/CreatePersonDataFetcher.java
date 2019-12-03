package com.usereserva.domain.service.graphQL.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usereserva.domain.model.Person;
import com.usereserva.domain.model.input.PersonInput;
import com.usereserva.domain.service.PersonService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CreatePersonDataFetcher implements DataFetcher<Person>{
	
	@Autowired
	private PersonService service;
	
	@Override
	public Person get(DataFetchingEnvironment environment) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Object rawInput = environment.getArgument("input");
		PersonInput person = objectMapper.convertValue(rawInput, PersonInput.class);
		
		return service.createPerson(person);
	}

}
