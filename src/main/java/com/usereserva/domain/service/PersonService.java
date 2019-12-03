package com.usereserva.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usereserva.domain.model.Contact;
import com.usereserva.domain.model.Person;
import com.usereserva.domain.model.enums.TypeContact;
import com.usereserva.domain.model.input.PersonInput;
import com.usereserva.domain.repository.ContactRepository;
import com.usereserva.domain.repository.PersonRepository;
import com.usereserva.domain.repository.PersonRepositoryCustom;



@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonRepositoryCustom repositoryCustom;
	
	@Autowired 
	private ContactRepository contactRepository;

	@Transactional
	public Person createPerson(PersonInput input) {
		final Person person = new Person();
		person.setName(input.getName());
		person.setLastName(input.getLastName());
		person.setBirthDate(input.getBirthDate());
		
		if(!input.getContacts().isEmpty()) {
			List<Contact> listContact = new ArrayList<Contact>();
			
			input.getContacts().forEach(c -> {
				Contact contact = new Contact();
				contact.setType(TypeContact.getByString(c.getType()));
				contact.setNumber(c.getNumber());
				contact.setPerson(person);
				listContact.add(contact);
			});
			
			person.setContacts(listContact);
		}
		
		
		return this.repository.save(person);
	}

	@Transactional
	public List<Person> getPersons(PersonInput input) {
		return repositoryCustom.filter(input);
	}

	public Person updatePerson(PersonInput input) {
		Optional<Person> person = repository.findById(input.getId());
        List<Contact> listContacts = new ArrayList<Contact>();
		
		
		person.ifPresent(p -> {
			p.setName(input.getName());
			p.setLastName(input.getLastName());
			p.setBirthDate(input.getBirthDate());
			
			if(!input.getContacts().isEmpty()) {
				contactRepository.deleteContatoByIdPerson(p.getId());
				
				input.getContacts().forEach(c -> {
					Contact contact = new Contact();
					contact.setType(TypeContact.getByString(c.getType()));
					contact.setNumber(c.getNumber());
					contact.setPerson(person.get());
					listContacts.add(contact);
				});
				
			}
			p.setContacts(listContacts);
			
		});

		return this.repository.save(person.get());
	}

	public Boolean deletePerson(Long id) {
		repository.deleteById(id);
		return true;
	}


	@Transactional
	public Optional<Person> getPerson(final Long id) {
		return repository.findById(id);
	}

}
