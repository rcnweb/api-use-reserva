package com.usereserva.domain.repository;

import java.util.List;

import com.usereserva.domain.model.Person;
import com.usereserva.domain.model.input.PersonInput;

public interface PersonRepositoryCustom {

	public List<Person> filter(PersonInput input);
}
