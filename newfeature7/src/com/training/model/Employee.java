package com.training.model;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Employee {
	
	@EmbeddedId
	private KeyObject keyId;
	
	private String name;
	private String surname;
	
	public KeyObject getKeyId() {
		return keyId;
	}
	public void setKeyId(KeyObject keyId) {
		this.keyId = keyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	
}
