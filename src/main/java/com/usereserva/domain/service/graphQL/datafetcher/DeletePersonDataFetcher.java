package com.usereserva.domain.service.graphQL.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.usereserva.domain.service.PersonService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class DeletePersonDataFetcher implements DataFetcher<Boolean>{
	
	@Autowired
	private PersonService service;
	
	@Override
	public Boolean get(DataFetchingEnvironment environment) {
		
		String id = environment.getArgument("id");
		
		return service.deletePerson(Long.parseLong(id));
	}

}
