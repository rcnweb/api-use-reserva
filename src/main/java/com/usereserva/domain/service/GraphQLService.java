package com.usereserva.domain.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.usereserva.domain.service.graphQL.datafetcher.CreatePersonDataFetcher;
import com.usereserva.domain.service.graphQL.datafetcher.DeletePersonDataFetcher;
import com.usereserva.domain.service.graphQL.datafetcher.FilterPersonDataFetcher;
import com.usereserva.domain.service.graphQL.datafetcher.UpdatePersonDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {

	@Value("classpath:person.graphqls")
	Resource resource;

	private GraphQL graphQL;

	@Autowired
	private FilterPersonDataFetcher filterPersonDataFetcher;

	@Autowired
	private CreatePersonDataFetcher createPersonDataFetcher;

	@Autowired
	private DeletePersonDataFetcher deletePersonDataFetcher;
	
	@Autowired
	private UpdatePersonDataFetcher updatePersonDataFetcher;
	
	@PostConstruct
	private void loadSchema() throws IOException {
		

		// get the schema
		InputStream schemaFile = resource.getInputStream();

		InputStreamReader isReader = new InputStreamReader(schemaFile);
		
	    //Creating a BufferedReader object
	      BufferedReader reader = new BufferedReader(isReader);
	      StringBuffer sb = new StringBuffer();
	      String str;
	      while((str = reader.readLine())!= null){
	         sb.append(str);
	      }

		// parse schema
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sb.toString());
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Mutation",
						typeWiring -> typeWiring
						.dataFetcher("createPerson", createPersonDataFetcher)
						.dataFetcher("deletePerson", deletePersonDataFetcher)
						.dataFetcher("updatePerson", updatePersonDataFetcher)
						)
				.type("Query", typeWiring -> typeWiring.dataFetcher("persons", filterPersonDataFetcher)).build();
	}

	public GraphQL getGraphQL() {
		return graphQL;
	}
	
	

}
