package com.usereserva.domain.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.usereserva.domain.model.enums.TypeContact;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Entity
public class Contact implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private TypeContact type;
	@Column(name = "number")
	private String number;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personId")
	private Person person;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public TypeContact getType() {
		return type;
	}
	public void setType(TypeContact type) {
		this.type = type;
	}
	
	
	

}
