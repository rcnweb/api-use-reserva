package com.usereserva.domain.model.input;

import java.util.Date;
import java.util.List;

public class PersonInput {
	
	private Long id;
	private String name;
	private String lastName;
	private Date birthDate;
	private List<ContactInput> contacts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public List<ContactInput> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactInput> contacts) {
		this.contacts = contacts;
	}

	

}
