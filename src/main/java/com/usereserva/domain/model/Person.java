package com.usereserva.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;


@EqualsAndHashCode
@Entity
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "lastName")
	private String lastName;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthDate")
	private Date birthDate;
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Contact> contacts;
	
	public Person() {}
	
	public Person(String name, String lastName, Date birthDate,  List<Contact> contacts) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.contacts = contacts;
	}
	
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
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	



}
